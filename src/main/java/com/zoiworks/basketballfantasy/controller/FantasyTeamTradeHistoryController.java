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

import com.zoiworks.basketballfantasy.model.FantasyTeamTradeHistory;
import com.zoiworks.basketballfantasy.service.FantasyTeamTradeHistoryService;

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
