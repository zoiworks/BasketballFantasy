package com.zoiworks.kblfantasy.controller;

import com.zoiworks.kblfantasy.model.Competition;
import com.zoiworks.kblfantasy.service.CompetitionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
