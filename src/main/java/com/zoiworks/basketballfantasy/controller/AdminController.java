package com.zoiworks.basketballfantasy.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zoiworks.basketballfantasy.model.Championship;
import com.zoiworks.basketballfantasy.model.User;
import com.zoiworks.basketballfantasy.repository.ChampionshipRepository;
import com.zoiworks.basketballfantasy.repository.TeamRepository;
import com.zoiworks.basketballfantasy.repository.UserRepository;
import com.zoiworks.basketballfantasy.service.UserService;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ChampionshipRepository championshipRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/index")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public String showAdminPanel(Model model, Authentication auth) {
        User user = userService.findByEmail(auth.getName()).orElseThrow();

        List<Championship> championships;
        if (user.getRoles().contains("ADMIN")) {
            championships = championshipRepository.findAll(); // 🟢 Χρησιμοποιούμε Championship
        } else {
            championships = championshipRepository.findByManagerId(user.getId());
        }

        model.addAttribute("championships", championships);

        if (user.getRoles().contains("ADMIN")) {
            model.addAttribute("managers", userService.findManagers());
        }

        return "admin/index";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Επιτρέπει empty string να μεταφραστεί σε null για Integers
        binder.registerCustomEditor(
                Integer.class,
                "manager.id",
                new CustomNumberEditor(Integer.class, true));
    }

    // Σελίδα λίστας πρωταθλημάτων
    @PostMapping("/championships")
    @PreAuthorize("hasRole('ADMIN')") // ✅ ΤΩΡΑ μόνο ο admin μπορεί να δημιουργήσει πρωτάθλημα
    // 1) Δημιουργία νέου πρωταθλήματος
    public String createChampionship(
            @ModelAttribute Championship championship,
            @RequestParam(value = "managerId", required = false) Integer managerId,
            @RequestParam("photo") MultipartFile photoFile,
            Authentication auth) {

        // ✅ Ανάκτηση τρέχοντος χρήστη
        User currentUser = userService.findByEmail(auth.getName())
                .orElseThrow();

        // ✅ Επιβεβαίωση ότι είναι admin — για έξτρα ασφάλεια (πέρα από το annotation)
        if (!currentUser.getRoles().contains("ADMIN")) {
            return "redirect:/unauthorized"; // Μπορείς να δείξεις custom error page
        }

        // ✅ Ανάθεση manager
        if (managerId != null) {
            User mgr = userService.findById(managerId)
                    .orElseThrow(() -> new IllegalArgumentException("Manager not found"));
            championship.setManager(mgr);
        } else {
            championship.setManager(null); // Αν δεν επιλέχθηκε
        }

        // 2) Upload + resize εικόνας
        if (photoFile != null && !photoFile.isEmpty()) {
            try {
                String ct = photoFile.getContentType();
                if (!"image/jpeg".equals(ct) && !"image/png".equals(ct)) {
                    return "redirect:/admin/championships?error=unsupported_image";
                }

                String uploadDir = "src/main/resources/static/uploads/championships/";
                String fileName = UUID.randomUUID() + "_" + photoFile.getOriginalFilename();
                Path target = Paths.get(uploadDir).resolve(fileName);
                Files.createDirectories(target.getParent());

                BufferedImage original = ImageIO.read(photoFile.getInputStream());
                if (original == null) {
                    return "redirect:/admin/championships?error=read_fail";
                }

                BufferedImage resized = Thumbnails.of(original)
                        .size(200, 200)
                        .outputQuality(0.9)
                        .asBufferedImage();
                ImageIO.write(resized, "jpg", target.toFile());

                championship.setPhotoUrl("/uploads/championships/" + fileName);
            } catch (IOException e) {
                // e.printStackTrace();
                return "redirect:/admin/championships?error=io_exception";
            }
        }

        // 3) Τελική αποθήκευση
        championshipRepository.save(championship);
        return "redirect:/admin/index";
    }

    @GetMapping("/users")
    @ResponseBody
    public ResponseEntity<?> getAllUsers(Authentication auth) {
        // Παίρνουμε τους ρόλους του συνδεδεμένου χρήστη
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        // Αν ΔΕΝ είναι ADMIN, επιστρέφουμε 403 με custom μήνυμα
        boolean isAdmin = authorities.stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Δεν έχετε δικαίωμα πρόσβασης σε αυτή τη λειτουργία.");
        }
        // Αν είναι admin → επιστρέφουμε τους χρήστες
        return ResponseEntity.ok(userRepository.findAll());
    }

    // 🔐 Επιτρέπεται μόνο σε χρήστες με ρόλο ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/users/{id}/roles")
    public ResponseEntity<?> updateUserRoles(@PathVariable int id, @RequestBody Map<String, List<String>> body) {

        // 🎯 Παίρνουμε τους ρόλους που στάλθηκαν από το frontend
        List<String> requestedRoles = body.get("roles");

        // ✅ Εκτύπωση του συνδεδεμένου χρήστη και των ρόλων του για debug
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("✅ Συνδεδεμένος χρήστης: " + auth.getName());
        System.out.println("✅ Ρόλοι: " + auth.getAuthorities());

        // 🔎 Αναζήτηση του χρήστη που θέλουμε να ενημερώσουμε
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            // ❌ Αν δεν υπάρχει ο χρήστης, επιστρέφουμε 404
            return ResponseEntity.notFound().build();
        }

        // ✔️ Ο χρήστης που θα ενημερωθεί
        User user = optionalUser.get();

        // Δημιουργούμε νέο σύνολο ρόλων που θα αποθηκευτεί — πάντα περιλαμβάνει τον
        // "USER"
        Set<String> updatedRoles = new HashSet<>();
        updatedRoles.add("USER"); // Κάθε χρήστης έχει πάντα τον ρόλο USER

        // ✅ Προσθέτουμε μόνο ADMIN ή MANAGER αν στάλθηκαν από το frontend
        if (requestedRoles != null) {
            for (String role : requestedRoles) {
                if (role.equals("ADMIN") || role.equals("MANAGER")) {
                    updatedRoles.add(role);
                }
            }
        }

        // Ενημερώνουμε τον χρήστη με τους νέους ρόλους και τον αποθηκεύουμε
        user.setRoles(updatedRoles);
        userRepository.save(user);

        // 📤 Επιστρέφουμε επιτυχία
        return ResponseEntity.ok().build();
    }

    // Διαγραφή User μόνο από admin
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/{id}") // 🧭 HTTP DELETE για διαγραφή χρήστη με βάση το ID
    public ResponseEntity<?> deleteUser(@PathVariable int id) {

        // Ελέγχουμε αν υπάρχει χρήστης με αυτό το ID
        if (!userRepository.existsById(id)) {
            // ❌ Αν δεν υπάρχει, επιστρέφουμε 404 Not Found
            return ResponseEntity.notFound().build();
        }

        // Διαγράφουμε τον χρήστη από τη βάση
        userRepository.deleteById(id);

        // ✅ Επιστρέφουμε HTTP 200 OK για επιτυχία
        return ResponseEntity.ok().build();
    }

}
