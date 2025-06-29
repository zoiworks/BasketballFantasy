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

import com.zoiworks.basketballfantasy.model.Round;
import com.zoiworks.basketballfantasy.service.RoundService;

/**
 * Controller για τη διαχείριση των αγωνιστικών (Round).
 * Παρέχει endpoints για δημιουργία, ανάκτηση, ενημέρωση και διαγραφή.
 */
@RestController
@RequestMapping("/api/rounds")
public class RoundController {

    private final RoundService roundService;

    // Constructor injection
    public RoundController(RoundService roundService) {
        this.roundService = roundService;
    }

    // GET /api/rounds - Επιστροφή όλων των αγωνιστικών
    @GetMapping
    public List<Round> getAllRounds() {
        return roundService.getAllRounds();
    }

    // GET /api/rounds/{id} - Επιστροφή αγωνιστικής βάσει ID
    @GetMapping("/{id}")
    public Optional<Round> getRoundById(@PathVariable Integer id) {
        return roundService.getRoundById(id);
    }

    // POST /api/rounds - Δημιουργία νέας αγωνιστικής
    @PostMapping
    public Round createRound(@RequestBody Round round) {
        return roundService.saveRound(round);
    }

    // PUT /api/rounds/{id} - Ενημέρωση υπάρχουσας αγωνιστικής
    @PutMapping("/{id}")
    public Round updateRound(@PathVariable Integer id, @RequestBody Round round) {
        round.setId(id);
        return roundService.saveRound(round);
    }

    // DELETE /api/rounds/{id} - Διαγραφή αγωνιστικής βάσει ID
    @DeleteMapping("/{id}")
    public void deleteRound(@PathVariable Integer id) {
        roundService.deleteRound(id);
    }
}

