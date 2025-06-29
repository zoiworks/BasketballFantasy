package com.zoiworks.kblfantasy.controller;

import com.zoiworks.kblfantasy.model.FantasyLeague;
import com.zoiworks.kblfantasy.service.FantasyLeagueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller για την οντότητα FantasyLeague.
 * Παρέχει endpoints για προβολή, δημιουργία, ενημέρωση και διαγραφή fantasy πρωταθλημάτων.
 */
@RestController
@RequestMapping("/api/fantasy-leagues")
public class FantasyLeagueController {

    private final FantasyLeagueService fantasyLeagueService;

    public FantasyLeagueController(FantasyLeagueService fantasyLeagueService) {
        this.fantasyLeagueService = fantasyLeagueService;
    }

    // Επιστροφή όλων των fantasy πρωταθλημάτων
    @GetMapping
    public List<FantasyLeague> getAllLeagues() {
        return fantasyLeagueService.findAll();
    }

    // Επιστροφή μιας fantasy λίγκας με βάση το ID
    @GetMapping("/{id}")
    public Optional<FantasyLeague> getLeagueById(@PathVariable Integer id) {
        return fantasyLeagueService.findById(id);
    }

    // Δημιουργία νέας fantasy λίγκας
    @PostMapping
    public FantasyLeague createLeague(@RequestBody FantasyLeague fantasyLeague) {
        return fantasyLeagueService.save(fantasyLeague);
    }

    // Ενημέρωση fantasy λίγκας
    @PutMapping("/{id}")
    public FantasyLeague updateLeague(@PathVariable Integer id, @RequestBody FantasyLeague updatedLeague) {
        updatedLeague.setId(id);
        return fantasyLeagueService.save(updatedLeague);
    }

    // Διαγραφή fantasy λίγκας
    @DeleteMapping("/{id}")
    public void deleteLeague(@PathVariable Integer id) {
        fantasyLeagueService.deleteById(id);
    }
}

