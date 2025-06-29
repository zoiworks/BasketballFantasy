package com.zoiworks.kblfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoiworks.kblfantasy.model.Championship;

public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {
    // Μπορείς να προσθέσεις custom queries αν χρειαστεί
}

