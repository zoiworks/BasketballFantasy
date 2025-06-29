package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.FantasyTeamTradeHistory;

@Repository
public interface FantasyTeamTradeHistoryRepository extends JpaRepository<FantasyTeamTradeHistory, Integer> {

}
