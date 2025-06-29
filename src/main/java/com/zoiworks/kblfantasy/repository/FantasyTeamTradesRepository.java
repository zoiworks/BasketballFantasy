package com.zoiworks.kblfantasy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.kblfantasy.model.FantasyTeamTrades;

@Repository
public interface FantasyTeamTradesRepository extends JpaRepository<FantasyTeamTrades, Integer> {

    Optional<FantasyTeamTrades> findByFantasyTeamIdAndRoundId(int fantasyTeamId, int roundId);


}
