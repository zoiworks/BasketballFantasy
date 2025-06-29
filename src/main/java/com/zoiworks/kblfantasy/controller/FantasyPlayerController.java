package com.zoiworks.kblfantasy.controller;

import com.zoiworks.kblfantasy.model.FantasyPlayer;
import com.zoiworks.kblfantasy.service.FantasyPlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
