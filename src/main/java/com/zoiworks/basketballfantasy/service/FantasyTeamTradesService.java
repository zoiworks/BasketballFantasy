package com.zoiworks.basketballfantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.FantasyTeamTrades;
import com.zoiworks.basketballfantasy.repository.FantasyTeamTradesRepository;

@Service
public class FantasyTeamTradesService {

    private final FantasyTeamTradesRepository tradesRepository;

    public FantasyTeamTradesService(FantasyTeamTradesRepository tradesRepository) {
        this.tradesRepository = tradesRepository;
    }

    public List<FantasyTeamTrades> findAll() {
        return tradesRepository.findAll();
    }

    public Optional<FantasyTeamTrades> findById(int id) {
        return tradesRepository.findById(id);
    }

    public FantasyTeamTrades save(FantasyTeamTrades trades) {
        return tradesRepository.save(trades);
    }

    public void deleteById(int id) {
        tradesRepository.deleteById(id);
    }

    public Optional<FantasyTeamTrades> findByFantasyTeamIdAndRoundId(int teamId, int roundId) {
        return tradesRepository.findByFantasyTeamIdAndRoundId(teamId, roundId);
    }
}
