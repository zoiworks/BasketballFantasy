package com.zoiworks.kblfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.kblfantasy.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
