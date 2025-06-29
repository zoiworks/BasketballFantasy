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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zoiworks.basketballfantasy.model.FantasyTeamTrades;
import com.zoiworks.basketballfantasy.service.FantasyTeamTradesService;

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
