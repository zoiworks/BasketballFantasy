package com.zoiworks.kblfantasy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoiworks.kblfantasy.model.Team;
import com.zoiworks.kblfantasy.service.TeamService;

/**
 * Controller για την οντότητα Team.
 * Παρέχει endpoints για προβολή, δημιουργία, ενημέρωση και διαγραφή ομάδων.
 */
@Controller
@RequestMapping("/admin/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // Επιστροφή όλων των ομάδων
    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // Επιστροφή ομάδας βάσει ID
    @GetMapping("/{id}")
    public Optional<Team> getTeamById(@PathVariable Integer id) {
        return teamService.getTeamById(id);
    }

    // Δημιουργία νέας ομάδας
    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }

    // Ενημέρωση υπάρχουσας ομάδας
    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Integer id, @RequestBody Team updatedTeam) {
        updatedTeam.setId(id); // διασφάλιση σωστού ID
        return teamService.saveTeam(updatedTeam);
    }

}
