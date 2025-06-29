package com.zoiworks.kblfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.kblfantasy.model.FantasyPlayer;

@Repository
public interface FantasyPlayerRepository extends JpaRepository<FantasyPlayer, Integer>{

}
