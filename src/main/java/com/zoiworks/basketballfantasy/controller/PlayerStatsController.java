package com.zoiworks.basketballfantasy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoiworks.basketballfantasy.model.PlayerStats;
import com.zoiworks.basketballfantasy.service.PlayerStatsService;

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
