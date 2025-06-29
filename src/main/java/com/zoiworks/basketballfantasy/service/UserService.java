package com.zoiworks.basketballfantasy.service;

import java.util.List; // Οντότητα User
import java.util.Optional; // Repository για τους χρήστες

import org.springframework.stereotype.Service; // Για να δηλώσουμε την κλάση ως Service

import com.zoiworks.basketballfantasy.model.User;
import com.zoiworks.basketballfantasy.repository.UserRepository;

/**
 * Υπηρεσία για διαχείριση των χρηστών του συστήματος.
 * Παρέχει βασικές λειτουργίες όπως δημιουργία, εύρεση και διαγραφή χρηστών.
 */
@Service
public class UserService {

    private final UserRepository userRepository; // Repository για πρόσβαση στη βάση δεδομένων

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository; // Αρχικοποίηση μέσω constructor injection
    }

    // Επιστρέφει όλους τους χρήστες
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Αναζήτηση χρήστη με βάση το ID
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    // Αποθήκευση ή ενημέρωση χρήστη
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Διαγραφή χρήστη με βάση το ID
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    // Εύρεση χρήστη με βάση το email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> findManagers() {
        return userRepository.findByRole("MANAGER");
    }

}
