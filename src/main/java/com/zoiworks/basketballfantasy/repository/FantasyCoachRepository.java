package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.FantasyCoach;

@Repository
public interface FantasyCoachRepository extends JpaRepository<FantasyCoach, Integer> {

}
