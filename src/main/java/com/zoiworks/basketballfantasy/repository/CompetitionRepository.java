package com.zoiworks.basketballfantasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Integer> {
    //Αναζήτηση με βάση την Σεζον
    List<Competition> findBySeason(String season);

    List<Competition> findByManagerId(Integer managerId);


}
