package com.zoiworks.basketballfantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.Competition;
import com.zoiworks.basketballfantasy.repository.CompetitionRepository;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;
    
    public CompetitionService(CompetitionRepository championshipRepository) {
        this.competitionRepository = championshipRepository;
    }

    public List<Competition> findAllChampionships() {
        return competitionRepository.findAll();
    }

    public Optional<Competition> findById(Integer id) {
        return competitionRepository.findById(id);
    }

    public Competition saveChampionship(Competition championship) {
        return competitionRepository.save(championship);
    }

    public void deleteChampionship(Integer id) {
        competitionRepository.deleteById(id);
    }

    
}
