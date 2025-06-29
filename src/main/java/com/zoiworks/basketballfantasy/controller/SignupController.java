package com.zoiworks.basketballfantasy.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoiworks.basketballfantasy.model.User;
import com.zoiworks.basketballfantasy.repository.UserRepository;

@Controller
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Εμφάνιση της φόρμας εγγραφής
    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup"; // Επιστρέφει signup.html
    }

    // Επεξεργασία της φόρμας εγγραφής (POST)
    @PostMapping("/signup")
    public String processSignup(
            @RequestParam String email,
            @RequestParam String password) {

        // Αν υπάρχει ήδη χρήστης με το ίδιο email, επέστρεψε στο signup με μήνυμα
        if (userRepository.findByEmail(email).isPresent()) {
            return "redirect:/signup?error=email";
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        // Προσωρινές default τιμές
        user.setFirstName("Default");
        user.setLastName("User");
        user.getRoles().add("USER");
        user.setStatus(true);
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return "redirect:/login";
    }

}
