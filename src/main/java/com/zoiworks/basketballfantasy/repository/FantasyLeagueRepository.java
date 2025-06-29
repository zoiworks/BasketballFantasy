package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.FantasyLeague;

@Repository
public interface FantasyLeagueRepository extends JpaRepository<FantasyLeague, Integer> {
    // Εδώ μπορείς αργότερα να προσθέσεις custom queries
}
