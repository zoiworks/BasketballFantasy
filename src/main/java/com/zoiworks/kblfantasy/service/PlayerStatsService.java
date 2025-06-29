package com.zoiworks.kblfantasy.service;

import com.zoiworks.kblfantasy.model.PlayerStats; // Οντότητα στατιστικών παίκτη
import com.zoiworks.kblfantasy.repository.PlayerStatsRepository; // Αντίστοιχο repository

import org.springframework.stereotype.Service; // Μαρκάρει την κλάση ως service

import java.util.List; // Για λίστα από στατιστικά
import java.util.Optional; // Για ασφαλή αναζήτηση

/**
 * Παρέχει βασικές λειτουργίες CRUD για τα στατιστικά παικτών (PlayerStats),
 * όπως δημιουργία, ανάκτηση, ενημέρωση και διαγραφή.
 */
@Service
public class PlayerStatsService {

    // Το repository που συνδέεται με τη βάση δεδομένων για τα PlayerStats
    private final PlayerStatsRepository playerStatsRepository;

    // Constructor-based dependency injection
    public PlayerStatsService(PlayerStatsRepository playerStatsRepository) {
        this.playerStatsRepository = playerStatsRepository; // Αποθήκευση του repository
    }

    // Επιστρέφει όλα τα στατιστικά
    public List<PlayerStats> getAllStats() {
        return playerStatsRepository.findAll();
    }

    // Επιστρέφει τα στατιστικά με βάση το ID
    public Optional<PlayerStats> getStatsById(Integer id) {
        return playerStatsRepository.findById(id);
    }

    // Αποθήκευση ή ενημέρωση στατιστικών
    public PlayerStats saveStats(PlayerStats stats) {
        return playerStatsRepository.save(stats);
    }

    // Διαγραφή στατιστικών βάσει ID
    public void deleteStats(Integer id) {
        playerStatsRepository.deleteById(id);
    }
}
