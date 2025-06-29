package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

}
