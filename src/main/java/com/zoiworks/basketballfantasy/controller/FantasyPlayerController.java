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

import com.zoiworks.basketballfantasy.model.FantasyPlayer;
import com.zoiworks.basketballfantasy.service.FantasyPlayerService;

/**
 * Controller για διαχείριση των Fantasy Players.
 * Παρέχει endpoints για ανάκτηση, δημιουργία, διαγραφή και ενημέρωση.
 */
@RestController
@RequestMapping("/api/fantasy-players")
public class FantasyPlayerController {

    private final FantasyPlayerService fantasyPlayerService;

    public FantasyPlayerController(FantasyPlayerService fantasyPlayerService) {
        this.fantasyPlayerService = fantasyPlayerService;
    }

    // GET /api/fantasy-players
    @GetMapping
    public List<FantasyPlayer> getAllFantasyPlayers() {
        return fantasyPlayerService.findAll();
    }

    // GET /api/fantasy-players/{id}
    @GetMapping("/{id}")
    public Optional<FantasyPlayer> getFantasyPlayerById(@PathVariable Integer id) {
        return fantasyPlayerService.findById(id);
    }

    // POST /api/fantasy-players
    @PostMapping
    public FantasyPlayer createFantasyPlayer(@RequestBody FantasyPlayer fantasyPlayer) {
        return fantasyPlayerService.save(fantasyPlayer);
    }

    // PUT /api/fantasy-players/{id}
    @PutMapping("/{id}")
    public FantasyPlayer updateFantasyPlayer(@PathVariable Integer id, @RequestBody FantasyPlayer updatedFantasyPlayer) {
        updatedFantasyPlayer.setId(id);
        return fantasyPlayerService.save(updatedFantasyPlayer);
    }

    // DELETE /api/fantasy-players/{id}
    @DeleteMapping("/{id}")
    public void deleteFantasyPlayer(@PathVariable Integer id) {
        fantasyPlayerService.deleteById(id);
    }
}
