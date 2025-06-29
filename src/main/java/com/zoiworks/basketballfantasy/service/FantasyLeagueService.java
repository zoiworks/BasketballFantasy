package com.zoiworks.basketballfantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.FantasyLeague;
import com.zoiworks.basketballfantasy.repository.FantasyLeagueRepository;

@Service
public class FantasyLeagueService {

    private final FantasyLeagueRepository fantasyLeagueRepository;

    public FantasyLeagueService(FantasyLeagueRepository fantasyLeagueRepository) {
        this.fantasyLeagueRepository = fantasyLeagueRepository;
    }

    public List<FantasyLeague> findAll() {
        return fantasyLeagueRepository.findAll();
    }

    public Optional<FantasyLeague> findById(Integer id) {
        return fantasyLeagueRepository.findById(id);
    }

    public FantasyLeague save(FantasyLeague fantasyLeague) {
        return fantasyLeagueRepository.save(fantasyLeague);
    }

    public void deleteById(Integer id) {
        fantasyLeagueRepository.deleteById(id);
    }
}
