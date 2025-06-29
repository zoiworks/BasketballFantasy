package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.FantasyPlayer;

@Repository
public interface FantasyPlayerRepository extends JpaRepository<FantasyPlayer, Integer>{

}
