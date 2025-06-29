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

import com.zoiworks.basketballfantasy.model.Coach;
import com.zoiworks.basketballfantasy.service.CoachService;

/**
 * Controller για την οντότητα Coach.
 * Παρέχει endpoints για προβολή, δημιουργία, ενημέρωση και διαγραφή προπονητών.
 */
@RestController
@RequestMapping("/api/coaches")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    // Επιστροφή όλων των προπονητών
    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.findAll();
    }

    // Επιστροφή προπονητή βάσει ID
    @GetMapping("/{id}")
    public Optional<Coach> getCoachById(@PathVariable Integer id) {
        return coachService.findById(id);
    }

    // Δημιουργία νέου προπονητή
    @PostMapping
    public Coach createCoach(@RequestBody Coach coach) {
        return coachService.save(coach);
    }

    // Ενημέρωση προπονητή
    @PutMapping("/{id}")
    public Coach updateCoach(@PathVariable Integer id, @RequestBody Coach updatedCoach) {
        updatedCoach.setId(id); // Ορισμός ID για ενημέρωση
        return coachService.save(updatedCoach);
    }

    // Διαγραφή προπονητή
    @DeleteMapping("/{id}")
    public void deleteCoach(@PathVariable Integer id) {
        coachService.deleteById(id);
    }
}
