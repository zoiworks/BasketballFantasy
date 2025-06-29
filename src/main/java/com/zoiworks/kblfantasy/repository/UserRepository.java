package com.zoiworks.kblfantasy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zoiworks.kblfantasy.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email); // Βρίσκει χρήστη με βάση το email

    @Query("SELECT u FROM User u WHERE :role IN elements(u.roles)")
    List<User> findByRole(@Param("role") String role);

}
