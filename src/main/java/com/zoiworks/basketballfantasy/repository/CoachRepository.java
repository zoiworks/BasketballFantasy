package com.zoiworks.basketballfantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoiworks.basketballfantasy.model.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {
    // Αν χρειαστείς custom queries, τα βάζεις εδώ
}
