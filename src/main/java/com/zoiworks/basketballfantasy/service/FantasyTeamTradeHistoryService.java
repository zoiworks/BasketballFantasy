package com.zoiworks.basketballfantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.FantasyTeamTradeHistory;
import com.zoiworks.basketballfantasy.repository.FantasyTeamTradeHistoryRepository;

@Service
public class FantasyTeamTradeHistoryService {

    private final FantasyTeamTradeHistoryRepository tradeHistoryRepository;

    public FantasyTeamTradeHistoryService(FantasyTeamTradeHistoryRepository tradeHistoryRepository) {
        this.tradeHistoryRepository = tradeHistoryRepository;
    }

    public List<FantasyTeamTradeHistory> findAll() {
        return tradeHistoryRepository.findAll();
    }

    public Optional<FantasyTeamTradeHistory> findById(Integer id) {
        return tradeHistoryRepository.findById(id);
    }

    public FantasyTeamTradeHistory save(FantasyTeamTradeHistory tradeHistory) {
        return tradeHistoryRepository.save(tradeHistory);
    }

    public void deleteById(Integer id) {
        tradeHistoryRepository.deleteById(id);
    }
}
