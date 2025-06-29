package com.zoiworks.kblfantasy.controller;

import com.zoiworks.kblfantasy.model.FantasyTeamHistory;
import com.zoiworks.kblfantasy.service.FantasyTeamHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
