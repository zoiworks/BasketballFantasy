package com.zoiworks.kblfantasy.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Αντιπροσωπεύει την καταγραφή των ανταλλαγών (trades) της φανταστικής ομάδας
 * για έναν συγκεκριμένο γύρο.
 */
@Entity
@Table(name = "FANTASY_TEAM_TRADE_HISTORY")
public class FantasyTeamTradeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FANTASY_TEAM_ID", nullable = false)
    // Σύνδεση με τη φανταστική ομάδα
    private FantasyTeam fantasyTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROUND_ID", nullable = false)
    // Σύνδεση με τον γύρο στον οποίο πραγματοποιείται η ανταλλαγή
    private Round round;

    @Column(name = "ADDED_PLAYERS", nullable = true)
    // Παίκτες που προστέθηκαν στην ομάδα (μπορεί να είναι λίστα με ID των παικτών)
    private String addedPlayers;

    @Column(name = "REMOVED_PLAYERS", nullable = true)
    // Παίκτες που αφαιρέθηκαν από την ομάδα (μπορεί να είναι λίστα με ID των
    // παικτών)
    private String removedPlayers;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters & Setters...

    public void addPlayers(String addedPlayers) {
        this.addedPlayers = addedPlayers;
    }

    public void removePlayers(String removedPlayers) {
        this.removedPlayers = removedPlayers;
    }

    // Επειδη δεν το διαβαζει το LomBok
    public void setId(Integer id) {
        this.id = id;
    }

    // public void undoTrade(FantasyTeam fantasyTeam, Round currentRound) {
    // // Παίρνουμε την τελευταία καταγραφή ιστορικού για αυτή την ομάδα και αυτόν
    // τον
    // // γύρο
    // FantasyTeamTradeHistory lastTradeHistory = fantasyTeamTradeHistoryRepository
    // .findLastByFantasyTeamAndRound(fantasyTeam, currentRound);

    // // Ανακτούμε τους παίκτες που προστέθηκαν και αφαιρέθηκαν
    // String addedPlayers = lastTradeHistory.getAddedPlayers();
    // String removedPlayers = lastTradeHistory.getRemovedPlayers();

    // // Επιστρέφουμε την ομάδα στην κατάσταση πριν τις αλλαγές
    // fantasyTeam.setPlayers(restorePlayers(addedPlayers, removedPlayers));

    // // Αποθηκεύουμε την ομάδα με την αποκατεστημένη κατάσταση
    // fantasyTeamRepository.save(fantasyTeam);
    // }

    // private List<FantasyPlayer> restorePlayers(String addedPlayers, String
    // removedPlayers) {
    // // Λογική για την αποκατάσταση των παικτών με βάση τα addedPlayers και
    // // removedPlayers
    // // Θα πρέπει να αναλύσουμε τα strings και να ενημερώσουμε την ομάδα με τους
    // // παίκτες
    // }
}
