package com.zoiworks.basketballfantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.FantasyTeam;
import com.zoiworks.basketballfantasy.repository.FantasyTeamRepository;

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
