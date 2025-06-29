package com.zoiworks.basketballfantasy.service;

import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.Coach;
import com.zoiworks.basketballfantasy.repository.CoachRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    public Optional<Coach> findById(Integer id) {
        return coachRepository.findById(id);
    }

    public Coach save(Coach coach) {
        return coachRepository.save(coach);
    }

    public void deleteById(Integer id) {
        coachRepository.deleteById(id);
    }
}
