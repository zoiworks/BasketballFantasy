package com.zoiworks.basketballfantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service; // Οντότητα Team

import com.zoiworks.basketballfantasy.model.Team;
import com.zoiworks.basketballfantasy.repository.TeamRepository;

/**
 * Υπηρεσία για διαχείριση των πραγματικών ομάδων (Team).
 * Παρέχει CRUD λειτουργίες όπως ανάκτηση, αποθήκευση και διαγραφή ομάδων.
 */
@Service
public class TeamService {

    private final TeamRepository teamRepository; // Αναφορά στο repository της Team

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository; // Αρχικοποίηση repository μέσω constructor
    }

    // Επιστροφή όλων των ομάδων
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    // Εύρεση ομάδας με βάση το ID
    public Optional<Team> getTeamById(Integer id) {
        return teamRepository.findById(id);
    }

    // Αποθήκευση ή ενημέρωση ομάδας
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    // Διαγραφή ομάδας βάσει ID
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }

}
