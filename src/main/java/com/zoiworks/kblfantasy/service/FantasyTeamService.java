package com.zoiworks.kblfantasy.service;

import com.zoiworks.kblfantasy.model.FantasyTeam;
import com.zoiworks.kblfantasy.repository.FantasyTeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FantasyTeamService {

    private final FantasyTeamRepository fantasyTeamRepository;

    public FantasyTeamService(FantasyTeamRepository fantasyTeamRepository) {
        this.fantasyTeamRepository = fantasyTeamRepository;
    }

    public List<FantasyTeam> findAll() {
        return fantasyTeamRepository.findAll();
    }

    public Optional<FantasyTeam> findById(Integer id) {
        return fantasyTeamRepository.findById(id);
    }

    public FantasyTeam save(FantasyTeam fantasyTeam) {
        return fantasyTeamRepository.save(fantasyTeam);
    }

    public void deleteById(Integer id) {
        fantasyTeamRepository.deleteById(id);
    }
}
