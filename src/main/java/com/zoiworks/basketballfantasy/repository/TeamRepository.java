package com.zoiworks.basketballfantasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findByCompetitionId(Integer competitionId);

}
