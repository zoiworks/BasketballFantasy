package com.zoiworks.basketballfantasy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zoiworks.basketballfantasy.model.Championship;

public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {

    @Query("SELECT c FROM Championship c LEFT JOIN FETCH c.competitions WHERE c.id = :id")
    Optional<Championship> findByIdWithCompetitions(@Param("id") Integer id);

    @Query("SELECT c FROM Championship c WHERE c.manager.id = :managerId")
    List<Championship> findByManagerId(@Param("managerId") Integer managerId);

    

}
