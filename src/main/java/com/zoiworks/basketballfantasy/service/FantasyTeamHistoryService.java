package com.zoiworks.basketballfantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.FantasyTeamHistory;
import com.zoiworks.basketballfantasy.repository.FantasyTeamHistoryRepository;

@Service
public class FantasyTeamHistoryService {

    private final FantasyTeamHistoryRepository fantasyTeamHistoryRepository;

    public FantasyTeamHistoryService(FantasyTeamHistoryRepository fantasyTeamHistoryRepository) {
        this.fantasyTeamHistoryRepository = fantasyTeamHistoryRepository;
    }

    public List<FantasyTeamHistory> findAll() {
        return fantasyTeamHistoryRepository.findAll();
    }

    public Optional<FantasyTeamHistory> findById(Integer id) {
        return fantasyTeamHistoryRepository.findById(id);
    }

    public FantasyTeamHistory save(FantasyTeamHistory history) {
        return fantasyTeamHistoryRepository.save(history);
    }

    public void deleteById(Integer id) {
        fantasyTeamHistoryRepository.deleteById(id);
    }
}
