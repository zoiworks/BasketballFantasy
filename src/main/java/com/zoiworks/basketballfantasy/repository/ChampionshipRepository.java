package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoiworks.basketballfantasy.model.Championship;

public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {
    // Μπορείς να προσθέσεις custom queries αν χρειαστεί
}

