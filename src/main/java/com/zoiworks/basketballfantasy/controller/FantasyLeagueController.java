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

import com.zoiworks.basketballfantasy.model.FantasyLeague;
import com.zoiworks.basketballfantasy.service.FantasyLeagueService;

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

