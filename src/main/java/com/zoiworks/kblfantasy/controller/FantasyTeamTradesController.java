package com.zoiworks.kblfantasy.controller;

import com.zoiworks.kblfantasy.model.FantasyTeamTrades;
import com.zoiworks.kblfantasy.service.FantasyTeamTradesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller για τις ανταλλαγές fantasy ομάδων σε συγκεκριμένο γύρο.
 * Παρέχει βασικές CRUD λειτουργίες και αναζήτηση με βάση ομάδα + γύρο.
 */
@RestController
@RequestMapping("/api/fantasy-trades")
public class FantasyTeamTradesController {

    private final FantasyTeamTradesService tradesService;

    public FantasyTeamTradesController(FantasyTeamTradesService tradesService) {
        this.tradesService = tradesService;
    }

    // GET /api/fantasy-trades
    @GetMapping
    public List<FantasyTeamTrades> getAllTrades() {
        return tradesService.findAll();
    }

    // GET /api/fantasy-trades/{id}
    @GetMapping("/{id}")
    public Optional<FantasyTeamTrades> getTradeById(@PathVariable int id) {
        return tradesService.findById(id);
    }

    // POST /api/fantasy-trades
    @PostMapping
    public FantasyTeamTrades createTrade(@RequestBody FantasyTeamTrades trade) {
        return tradesService.save(trade);
    }

    // PUT /api/fantasy-trades/{id}
    @PutMapping("/{id}")
    public FantasyTeamTrades updateTrade(@PathVariable int id, @RequestBody FantasyTeamTrades trade) {
        trade.setId(id);
        return tradesService.save(trade);
    }

    // DELETE /api/fantasy-trades/{id}
    @DeleteMapping("/{id}")
    public void deleteTrade(@PathVariable int id) {
        tradesService.deleteById(id);
    }

    // GET /api/fantasy-trades/by-team-and-round?teamId=1&roundId=2
    @GetMapping("/by-team-and-round")
    public Optional<FantasyTeamTrades> getByTeamAndRound(@RequestParam int teamId, @RequestParam int roundId) {
        return tradesService.findByFantasyTeamIdAndRoundId(teamId, roundId);
    }
}
