package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, Integer> { 

}
