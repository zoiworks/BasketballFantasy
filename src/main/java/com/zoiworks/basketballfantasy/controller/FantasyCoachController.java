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

import com.zoiworks.basketballfantasy.model.FantasyCoach;
import com.zoiworks.basketballfantasy.service.FantasyCoachServise;

/**
 * Controller για την οντότητα FantasyCoach.
 * Παρέχει endpoints για CRUD λειτουργίες.
 */
@RestController
@RequestMapping("/api/fantasy-coaches")
public class FantasyCoachController {

    private final FantasyCoachServise fantasyCoachServise;

    public FantasyCoachController(FantasyCoachServise fantasyCoachServise) {
        this.fantasyCoachServise = fantasyCoachServise;
    }

    // GET /api/fantasy-coaches - Λήψη όλων των fantasy προπονητών
    @GetMapping
    public List<FantasyCoach> getAll() {
        return fantasyCoachServise.findAll();
    }

    // GET /api/fantasy-coaches/{id} - Λήψη συγκεκριμένου προπονητή με βάση το ID
    @GetMapping("/{id}")
    public Optional<FantasyCoach> getById(@PathVariable Integer id) {
        return fantasyCoachServise.findById(id);
    }

    // POST /api/fantasy-coaches - Δημιουργία νέου fantasy προπονητή
    @PostMapping
    public FantasyCoach create(@RequestBody FantasyCoach coach) {
        return fantasyCoachServise.save(coach);
    }

    // PUT /api/fantasy-coaches/{id} - Ενημέρωση υπάρχοντος προπονητή
    @PutMapping("/{id}")
    public FantasyCoach update(@PathVariable Integer id, @RequestBody FantasyCoach coach) {
        coach.setId(id);
        return fantasyCoachServise.save(coach);
    }

    // DELETE /api/fantasy-coaches/{id} - Διαγραφή προπονητή με βάση το ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        fantasyCoachServise.deleteById(id);
    }
}

