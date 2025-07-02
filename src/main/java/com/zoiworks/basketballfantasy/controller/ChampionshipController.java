package com.zoiworks.basketballfantasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoiworks.basketballfantasy.model.Championship;
import com.zoiworks.basketballfantasy.service.ChampionshipService;
import com.zoiworks.basketballfantasy.service.UserService;

@Controller
@RequestMapping("/admin/championships")
public class ChampionshipController {

    private final ChampionshipService championshipService;

    @Autowired
    private UserService userService;

    public ChampionshipController(ChampionshipService championshipService) {
        this.championshipService = championshipService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("championships", championshipService.getAllChampionships());
        model.addAttribute("managers", userService.findManagers()); // λίστα managers για το dropdown
        return "admin/championships";
    }

    @GetMapping("/{id}")
    public String viewChampionship(@PathVariable Integer id, Model model) {
        Championship championship = championshipService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid championship ID: " + id));

        model.addAttribute("championship", championship);
        return "admin/championship"; // π.χ. admin/championship.html
    }

}
