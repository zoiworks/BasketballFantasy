package com.zoiworks.kblfantasy.controller;

import com.zoiworks.kblfantasy.model.PlayerStats;
import com.zoiworks.kblfantasy.service.PlayerStatsService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller για τη διαχείριση των στατιστικών παικτών (PlayerStats).
 * Παρέχει endpoints για CRUD λειτουργίες.
 */
@RestController
@RequestMapping("/api/player-stats")
public class PlayerStatsController {

    private final PlayerStatsService playerStatsService;

    public PlayerStatsController(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    // GET /api/player-stats - Επιστρέφει όλα τα στατιστικά παικτών
    @GetMapping
    public List<PlayerStats> getAllStats() {
        return playerStatsService.getAllStats();
    }

    // GET /api/player-stats/{id} - Επιστρέφει τα στατιστικά συγκεκριμένου παίκτη
    @GetMapping("/{id}")
    public Optional<PlayerStats> getStatsById(@PathVariable Integer id) {
        return playerStatsService.getStatsById(id);
    }

    // POST /api/player-stats - Δημιουργεί νέα στατιστικά
    @PostMapping
    public PlayerStats createStats(@RequestBody PlayerStats stats) {
        return playerStatsService.saveStats(stats);
    }

    // PUT /api/player-stats/{id} - Ενημερώνει υπάρχοντα στατιστικά
    @PutMapping("/{id}")
    public PlayerStats updateStats(@PathVariable Integer id, @RequestBody PlayerStats stats) {
        stats.setId(id);
        return playerStatsService.saveStats(stats);
    }

    // DELETE /api/player-stats/{id} - Διαγράφει στατιστικά βάσει ID
    @DeleteMapping("/{id}")
    public void deleteStats(@PathVariable Integer id) {
        playerStatsService.deleteStats(id);
    }
}
