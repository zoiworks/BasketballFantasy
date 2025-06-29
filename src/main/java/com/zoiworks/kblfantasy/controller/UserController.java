package com.zoiworks.kblfantasy.controller;

import com.zoiworks.kblfantasy.model.User;
import com.zoiworks.kblfantasy.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller για διαχείριση των χρηστών (User).
 * Παρέχει endpoints για δημιουργία, ανάκτηση, ενημέρωση και διαγραφή χρηστών.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor-based dependency injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /api/users - Επιστροφή όλων των χρηστών
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET /api/users/{id} - Επιστροφή χρήστη με βάση το ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // POST /api/users - Δημιουργία νέου χρήστη
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // PUT /api/users/{id} - Ενημέρωση χρήστη βάσει ID
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        return userService.saveUser(user);
    }

    // DELETE /api/users/{id} - Διαγραφή χρήστη βάσει ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    // GET /api/users/email/{email} - Εύρεση χρήστη με βάση το email
    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}

