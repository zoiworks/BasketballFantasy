package com.zoiworks.basketballfantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.FantasyPlayer;
import com.zoiworks.basketballfantasy.repository.FantasyPlayerRepository;

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
