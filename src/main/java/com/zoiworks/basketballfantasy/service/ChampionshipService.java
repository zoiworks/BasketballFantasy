package com.zoiworks.basketballfantasy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoiworks.basketballfantasy.model.Championship;
import com.zoiworks.basketballfantasy.repository.ChampionshipRepository;

@Service
public class ChampionshipService {

    @Autowired
    private ChampionshipRepository championshipRepository;


    public List<Championship> getAllChampionships() {
        return championshipRepository.findAll();
    }

    public Optional<Championship> getChampionshipById(Integer id) {
        return championshipRepository.findById(id);
    }

    public Championship saveChampionship(Championship championship) {
        return championshipRepository.save(championship);
    }

    public void deleteChampionship(Integer id) {
        championshipRepository.deleteById(id);
    }

    public Championship save(Championship championship) {
        return championshipRepository.save(championship);
    }

}
