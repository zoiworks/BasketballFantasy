package com.zoiworks.kblfantasy.controller;

import com.zoiworks.kblfantasy.model.Player;
import com.zoiworks.kblfantasy.service.PlayerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller για διαχείριση των πραγματικών παικτών (Player).
 * Παρέχει endpoints για CRUD λειτουργίες.
 */
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // GET /api/players - Επιστρέφει όλους τους παίκτες
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // GET /api/players/{id} - Επιστρέφει παίκτη βάσει ID
    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable Integer id) {
        return playerService.getPlayerById(id);
    }

    // POST /api/players - Δημιουργεί νέο παίκτη
    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    // PUT /api/players/{id} - Ενημερώνει παίκτη βάσει ID
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Integer id, @RequestBody Player player) {
        player.setId(id);
        return playerService.savePlayer(player);
    }

    // DELETE /api/players/{id} - Διαγράφει παίκτη βάσει ID
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }
}
