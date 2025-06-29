package com.zoiworks.kblfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.kblfantasy.model.FantasyCoach;

@Repository
public interface FantasyCoachRepository extends JpaRepository<FantasyCoach, Integer> {

}
