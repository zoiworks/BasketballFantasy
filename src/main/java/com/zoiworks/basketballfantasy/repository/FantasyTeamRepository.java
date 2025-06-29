package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.FantasyTeam;

@Repository
public interface FantasyTeamRepository extends JpaRepository<FantasyTeam, Integer>{

}
