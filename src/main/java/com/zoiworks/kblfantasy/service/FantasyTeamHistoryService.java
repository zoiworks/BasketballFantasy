package com.zoiworks.kblfantasy.service;

import com.zoiworks.kblfantasy.model.FantasyTeamHistory;
import com.zoiworks.kblfantasy.repository.FantasyTeamHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
