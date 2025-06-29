package com.zoiworks.kblfantasy.repository;

import com.zoiworks.kblfantasy.model.FantasyLeague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FantasyLeagueRepository extends JpaRepository<FantasyLeague, Integer> {
    // Εδώ μπορείς αργότερα να προσθέσεις custom queries
}
