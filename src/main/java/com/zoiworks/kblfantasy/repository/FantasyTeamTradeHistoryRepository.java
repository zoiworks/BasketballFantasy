package com.zoiworks.kblfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.kblfantasy.model.FantasyTeamTradeHistory;

@Repository
public interface FantasyTeamTradeHistoryRepository extends JpaRepository<FantasyTeamTradeHistory, Integer> {

}
