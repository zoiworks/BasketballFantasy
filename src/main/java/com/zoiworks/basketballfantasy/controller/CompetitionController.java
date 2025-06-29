package com.zoiworks.basketballfantasy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoiworks.basketballfantasy.model.Competition;
import com.zoiworks.basketballfantasy.service.CompetitionService;

@RestController
@RequestMapping("/api/championships")
public class CompetitionController {

    private final CompetitionService championshipService;

    public CompetitionController(CompetitionService championshipService) {
        this.championshipService = championshipService;
    }

    @GetMapping
    public List<Competition> getAll() {
        return championshipService.findAllChampionships();
    }

    @PostMapping
    public Competition create(@RequestBody Competition championship) {
        return championshipService.saveChampionship(championship);
    }
}
