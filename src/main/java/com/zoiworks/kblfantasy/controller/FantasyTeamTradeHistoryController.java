package com.zoiworks.kblfantasy.controller;

import com.zoiworks.kblfantasy.model.FantasyTeamTradeHistory;
import com.zoiworks.kblfantasy.service.FantasyTeamTradeHistoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller για την οντότητα FantasyTeamTradeHistory.
 * Παρέχει βασικά endpoints για CRUD λειτουργίες.
 */
@RestController
@RequestMapping("/api/trade-history")
public class FantasyTeamTradeHistoryController {

    private final FantasyTeamTradeHistoryService tradeHistoryService;

    public FantasyTeamTradeHistoryController(FantasyTeamTradeHistoryService tradeHistoryService) {
        this.tradeHistoryService = tradeHistoryService;
    }

    // GET /api/trade-history - Επιστροφή όλων των καταγραφών
    @GetMapping
    public List<FantasyTeamTradeHistory> getAll() {
        return tradeHistoryService.findAll();
    }

    // GET /api/trade-history/{id} - Αναζήτηση ανά ID
    @GetMapping("/{id}")
    public Optional<FantasyTeamTradeHistory> getById(@PathVariable Integer id) {
        return tradeHistoryService.findById(id);
    }

    // POST /api/trade-history - Δημιουργία νέας καταγραφής
    @PostMapping
    public FantasyTeamTradeHistory create(@RequestBody FantasyTeamTradeHistory tradeHistory) {
        return tradeHistoryService.save(tradeHistory);
    }

    // PUT /api/trade-history/{id} - Ενημέρωση υπάρχουσας καταγραφής
    @PutMapping("/{id}")
    public FantasyTeamTradeHistory update(@PathVariable Integer id, @RequestBody FantasyTeamTradeHistory tradeHistory) {
        tradeHistory.setId(id);
        return tradeHistoryService.save(tradeHistory);
    }

    // DELETE /api/trade-history/{id} - Διαγραφή καταγραφής
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        tradeHistoryService.deleteById(id);
    }
}
