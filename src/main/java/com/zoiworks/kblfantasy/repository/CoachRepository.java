package com.zoiworks.kblfantasy.repository;

import com.zoiworks.kblfantasy.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {
    // Αν χρειαστείς custom queries, τα βάζεις εδώ
}
