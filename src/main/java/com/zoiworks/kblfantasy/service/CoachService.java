package com.zoiworks.kblfantasy.service;

import com.zoiworks.kblfantasy.model.Coach;
import com.zoiworks.kblfantasy.repository.CoachRepository;
import org.springframework.stereotype.Service;

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
