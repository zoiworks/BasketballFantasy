package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.FantasyTeamHistory;

@Repository
public interface FantasyTeamHistoryRepository extends JpaRepository<FantasyTeamHistory, Integer>{

}
