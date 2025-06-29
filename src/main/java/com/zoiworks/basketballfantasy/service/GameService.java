package com.zoiworks.basketballfantasy.service;

import java.util.List; // Για να μαρκάρουμε την κλάση ως service
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.Game; // Λίστες
import com.zoiworks.basketballfantasy.repository.GameRepository; // Ασφαλής αναζήτηση με id

/**
 * Παρέχει βασικές λειτουργίες για την οντότητα Game,
 * όπως δημιουργία, ανάκτηση, ενημέρωση και διαγραφή.
 */
@Service
public class GameService {

    private final GameRepository gameRepository; // Το repository για τα Game entities
    
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository; // Αρχικοποίηση του repository μέσω constructor
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll(); // Επιστρέφει όλους τους αγώνες
    }

    public Optional<Game> getGameById(Integer id) {
        return gameRepository.findById(id); // Αναζήτηση αγώνα βάσει ID
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game); // Αποθήκευση ή ενημέρωση αγώνα
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id); // Διαγραφή αγώνα βάσει ID
    }
}
