package com.zoiworks.basketballfantasy.controller;

import org.springframework.web.bind.annotation.*;

import com.zoiworks.basketballfantasy.model.Game;
import com.zoiworks.basketballfantasy.service.GameService;

import java.util.List;
import java.util.Optional;

/**
 * Controller για την οντότητα Game.
 * Παρέχει endpoints για CRUD λειτουργίες στους αγώνες.
 */
@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // GET /api/games - Επιστροφή όλων των αγώνων
    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    // GET /api/games/{id} - Επιστροφή αγώνα βάσει ID
    @GetMapping("/{id}")
    public Optional<Game> getGameById(@PathVariable Integer id) {
        return gameService.getGameById(id);
    }

    // POST /api/games - Δημιουργία νέου αγώνα
    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameService.saveGame(game);
    }

    // PUT /api/games/{id} - Ενημέρωση υπάρχοντος αγώνα
    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Integer id, @RequestBody Game game) {
        game.setId(id);
        return gameService.saveGame(game);
    }

    // DELETE /api/games/{id} - Διαγραφή αγώνα
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Integer id) {
        gameService.deleteGame(id);
    }
}
