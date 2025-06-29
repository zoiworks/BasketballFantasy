package com.zoiworks.basketballfantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.FantasyCoach;
import com.zoiworks.basketballfantasy.repository.FantasyCoachRepository;

@Service
public class FantasyCoachServise {

    private final FantasyCoachRepository fantasyCoachRepository;

    public FantasyCoachServise(FantasyCoachRepository fantasyCoachRepository) {
        this.fantasyCoachRepository = fantasyCoachRepository;
    }

    public List<FantasyCoach> findAll() {
        return fantasyCoachRepository.findAll();
    }

    public Optional<FantasyCoach> findById(Integer id) {
        return fantasyCoachRepository.findById(id);
    }

    public FantasyCoach save(FantasyCoach fantasycoach) {
        return fantasyCoachRepository.save(fantasycoach);
    }

    public void deleteById(Integer id) {
        fantasyCoachRepository.deleteById(id);
    }

}
