package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.PlayerStats;

@Repository
public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Integer> {

}
