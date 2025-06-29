package com.zoiworks.kblfantasy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Αντιπροσωπεύει τις ανταλλαγές παικτών (trades) μιας φανταστικής ομάδας μέσα σε έναν γύρο.
 * Κάθε φανταστική ομάδα μπορεί να έχει περιορισμένο αριθμό ανταλλαγών σε κάθε γύρο.
 */
@Entity
@Table(name = "FANTASY_TEAM_TRADES", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"FANTASY_TEAM_ID", "ROUND_ID"})
})
public class FantasyTeamTrades {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό για την εγγραφή ανταλλαγής
    private int id;

    @ManyToOne
    @JoinColumn(name = "FANTASY_TEAM_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_FANTASY_TEAM_TRADES_TEAM"))
    // Σύνδεση με την φανταστική ομάδα που πραγματοποιεί την ανταλλαγή
    private FantasyTeam fantasyTeam;

    @ManyToOne
    @JoinColumn(name = "ROUND_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_FANTASY_TEAM_TRADES_ROUND"))
    // Σύνδεση με τον γύρο στο οποίο πραγματοποιείται η ανταλλαγή
    private Round round;

    @Column(name = "TRADES_LEFT", nullable = false)
    // Ο αριθμός των ανταλλαγών που απομένουν για την ομάδα στον συγκεκριμένο γύρο
    private int tradesLeft;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FantasyTeam getFantasyTeam() {
        return fantasyTeam;
    }

    public void setFantasyTeam(FantasyTeam fantasyTeam) {
        this.fantasyTeam = fantasyTeam;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public int getTradesLeft() {
        return tradesLeft;
    }

    public void setTradesLeft(int tradesLeft) {
        this.tradesLeft = tradesLeft;
    }

}
