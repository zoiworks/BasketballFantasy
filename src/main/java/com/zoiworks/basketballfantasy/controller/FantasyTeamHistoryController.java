package com.zoiworks.basketballfantasy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoiworks.basketballfantasy.model.FantasyTeamHistory;
import com.zoiworks.basketballfantasy.service.FantasyTeamHistoryService;

/**
 * Controller για τη διαχείριση του ιστορικού των fantasy ομάδων.
 * Παρέχει βασικά CRUD endpoints.
 */
@RestController
@RequestMapping("/api/fantasy-team-history")
public class FantasyTeamHistoryController {

    private final FantasyTeamHistoryService fantasyTeamHistoryService;

    public FantasyTeamHistoryController(FantasyTeamHistoryService fantasyTeamHistoryService) {
        this.fantasyTeamHistoryService = fantasyTeamHistoryService;
    }

    // GET /api/fantasy-team-history
    @GetMapping
    public List<FantasyTeamHistory> getAllHistories() {
        return fantasyTeamHistoryService.findAll();
    }

    // GET /api/fantasy-team-history/{id}
    @GetMapping("/{id}")
    public Optional<FantasyTeamHistory> getHistoryById(@PathVariable Integer id) {
        return fantasyTeamHistoryService.findById(id);
    }

    // POST /api/fantasy-team-history
    @PostMapping
    public FantasyTeamHistory createHistory(@RequestBody FantasyTeamHistory history) {
        return fantasyTeamHistoryService.save(history);
    }

    // PUT /api/fantasy-team-history/{id}
    @PutMapping("/{id}")
    public FantasyTeamHistory updateHistory(@PathVariable Integer id, @RequestBody FantasyTeamHistory updatedHistory) {
        updatedHistory.setId(id);
        return fantasyTeamHistoryService.save(updatedHistory);
    }

    // DELETE /api/fantasy-team-history/{id}
    @DeleteMapping("/{id}")
    public void deleteHistory(@PathVariable Integer id) {
        fantasyTeamHistoryService.deleteById(id);
    }
}
