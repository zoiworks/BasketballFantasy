package com.zoiworks.kblfantasy.controller;

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

import com.zoiworks.kblfantasy.model.FantasyTeam;
import com.zoiworks.kblfantasy.service.FantasyTeamService;

/**
 * Controller για διαχείριση των FantasyTeam.
 * Παρέχει endpoints για ανάκτηση, δημιουργία, ενημέρωση και διαγραφή φανταστικών ομάδων.
 */
@RestController
@RequestMapping("/api/fantasy-teams")
public class FantasyTeamController {

    private final FantasyTeamService fantasyTeamService;

    public FantasyTeamController(FantasyTeamService fantasyTeamService) {
        this.fantasyTeamService = fantasyTeamService;
    }

    // GET /api/fantasy-teams - Επιστρέφει όλες τις fantasy ομάδες
    @GetMapping
    public List<FantasyTeam> getAllFantasyTeams() {
        return fantasyTeamService.findAll();
    }

    // GET /api/fantasy-teams/{id} - Επιστρέφει μια fantasy ομάδα με βάση το ID
    @GetMapping("/{id}")
    public Optional<FantasyTeam> getFantasyTeamById(@PathVariable Integer id) {
        return fantasyTeamService.findById(id);
    }

    // POST /api/fantasy-teams - Δημιουργία νέας fantasy ομάδας
    @PostMapping
    public FantasyTeam createFantasyTeam(@RequestBody FantasyTeam fantasyTeam) {
        return fantasyTeamService.save(fantasyTeam);
    }

    // PUT /api/fantasy-teams/{id} - Ενημέρωση υπάρχουσας ομάδας
    @PutMapping("/{id}")
    public FantasyTeam updateFantasyTeam(@PathVariable Integer id, @RequestBody FantasyTeam fantasyTeam) {
        fantasyTeam.setId(id);
        return fantasyTeamService.save(fantasyTeam);
    }

    // DELETE /api/fantasy-teams/{id} - Διαγραφή ομάδας βάσει ID
    @DeleteMapping("/{id}")
    public void deleteFantasyTeam(@PathVariable Integer id) {
        fantasyTeamService.deleteById(id);
    }
}
