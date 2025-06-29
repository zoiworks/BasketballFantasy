package com.zoiworks.kblfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.kblfantasy.model.FantasyTeam;

@Repository
public interface FantasyTeamRepository extends JpaRepository<FantasyTeam, Integer>{

}
