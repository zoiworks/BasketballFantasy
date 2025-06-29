package com.zoiworks.kblfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.zoiworks.kblfantasy.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

}
