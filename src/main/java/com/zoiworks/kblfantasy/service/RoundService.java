package com.zoiworks.kblfantasy.service;

import com.zoiworks.kblfantasy.model.Round; // Οντότητα Round
import com.zoiworks.kblfantasy.repository.RoundRepository; // Repository της Round

import org.springframework.stereotype.Service; // Για δήλωση service

import java.util.List;
import java.util.Optional;

/**
 * Υπηρεσία για τη διαχείριση αγωνιστικών (Round).
 * Παρέχει λειτουργίες CRUD όπως δημιουργία, ανάκτηση, ενημέρωση και διαγραφή.
 */
@Service
public class RoundService {

    private final RoundRepository roundRepository; // Αναφορά στο repository

    // Constructor-based dependency injection
    public RoundService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository; // Αρχικοποίηση repository
    }

    // Επιστροφή όλων των αγωνιστικών
    public List<Round> getAllRounds() {
        return roundRepository.findAll();
    }

    // Εύρεση αγωνιστικής βάσει ID
    public Optional<Round> getRoundById(Integer id) {
        return roundRepository.findById(id);
    }

    // Αποθήκευση ή ενημέρωση αγωνιστικής
    public Round saveRound(Round round) {
        return roundRepository.save(round);
    }

    // Διαγραφή αγωνιστικής βάσει ID
    public void deleteRound(Integer id) {
        roundRepository.deleteById(id);
    }
}
