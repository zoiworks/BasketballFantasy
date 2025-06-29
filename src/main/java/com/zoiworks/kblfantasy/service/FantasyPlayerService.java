package com.zoiworks.kblfantasy.service;

import com.zoiworks.kblfantasy.model.FantasyPlayer;
import com.zoiworks.kblfantasy.repository.FantasyPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FantasyPlayerService {

    private final FantasyPlayerRepository fantasyPlayerRepository;

    public FantasyPlayerService(FantasyPlayerRepository fantasyPlayerRepository) {
        this.fantasyPlayerRepository = fantasyPlayerRepository;
    }

    public List<FantasyPlayer> findAll() {
        return fantasyPlayerRepository.findAll();
    }

    public Optional<FantasyPlayer> findById(Integer id) {
        return fantasyPlayerRepository.findById(id);
    }

    public FantasyPlayer save(FantasyPlayer fantasyPlayer) {
        return fantasyPlayerRepository.save(fantasyPlayer);
    }

    public void deleteById(Integer id) {
        fantasyPlayerRepository.deleteById(id);
    }
}
