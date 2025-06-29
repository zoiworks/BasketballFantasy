package com.zoiworks.kblfantasy.service;

import com.zoiworks.kblfantasy.model.FantasyLeague;
import com.zoiworks.kblfantasy.repository.FantasyLeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
