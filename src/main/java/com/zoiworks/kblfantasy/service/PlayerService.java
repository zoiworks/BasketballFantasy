package com.zoiworks.kblfantasy.service;

import com.zoiworks.kblfantasy.model.Player; // Import της οντότητας Player
import com.zoiworks.kblfantasy.repository.PlayerRepository; // Import του repository

import org.springframework.stereotype.Service; // Μαρκάρει την κλάση ως Service

import java.util.List; // Για χρήση λίστας
import java.util.Optional; // Για ασφαλή αναζήτηση με id

/**
 * Παρέχει βασικές λειτουργίες CRUD για την οντότητα Player,
 * όπως δημιουργία, ανάκτηση, ενημέρωση και διαγραφή παικτών.
 */
@Service
public class PlayerService {

    // Δηλώνουμε το repository που θα χρησιμοποιεί η υπηρεσία
    private final PlayerRepository playerRepository;

    // Constructor injection για να εισαχθεί αυτόματα το PlayerRepository
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository; // Αποθηκεύουμε το repository σε πεδίο της κλάσης
    }

    // Επιστρέφει όλους τους παίκτες
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Επιστρέφει έναν παίκτη βάσει του ID του, αν υπάρχει
    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    // Αποθηκεύει ή ενημερώνει έναν παίκτη
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    // Διαγράφει έναν παίκτη βάσει του ID του
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }
}
