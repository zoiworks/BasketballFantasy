package com.zoiworks.kblfantasy.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Αντιπροσωπεύει την ομάδα του χρήστη σε έναν συγκεκριμένο γύρο.
 * Καταγράφει το κόστος της ομάδας, τους πόντους, και τους παίκτες που ανήκαν σε
 * εκείνον τον γύρο.
 */
@Entity
@Table(name = "FANTASY_TEAM_HISTORY")
public class FantasyTeamHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FANTASY_TEAM_ID", nullable = false)
    // Σύνδεση με τη φανταστική ομάδα
    private FantasyTeam fantasyTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROUND_ID", nullable = false)
    // Σύνδεση με τον γύρο στον οποίο έγινε η ομάδα
    private Round round;

    @Column(name = "TOTAL_COST", nullable = false)
    // Το συνολικό κόστος της ομάδας (το κόστος των παικτών)
    private float totalCost;

    @Column(name = "TOTAL_POINTS", nullable = false)
    // Το σύνολο των πόντων της ομάδας για τον συγκεκριμένο γύρο
    private int totalPoints;

    @OneToMany(mappedBy = "fantasyTeamHistory", cascade = CascadeType.ALL)
    // Σύνδεση με τους παίκτες που ανήκαν στην ομάδα για εκείνο τον γύρο
    private List<FantasyPlayer> fantasyPlayers;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    // Ημερομηνία καταγραφής της ομάδας για τον γύρο
    private LocalDateTime createdAt = LocalDateTime.now();

    // Επειδη δεν το διαβαζει το LomBok
    public void setId(Integer id) {
        this.id = id;
    }

    // Μέθοδοι για υπολογισμό του κόστους και των πόντων

    // public void calculateTotalCost() {
    // this.totalCost = fantasyPlayers.stream()
    // .mapToDouble(FantasyPlayer::getPlayerPrice) // Συνολικό κόστος από την τιμή
    // κάθε παίκτη
    // .sum();
    // }

    // public void calculateTotalPoints() {
    // this.totalPoints = fantasyPlayers.stream()
    // .mapToInt(FantasyPlayer::getPir) // Συνολικοί πόντοι από το PIR κάθε παίκτη
    // .sum();
    // }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public List<FantasyPlayer> getFantasyPlayers() {
        return fantasyPlayers;
    }

    public void setFantasyPlayers(List<FantasyPlayer> fantasyPlayers) {
        this.fantasyPlayers = fantasyPlayers;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public FantasyTeam getFantasyTeam() {
        return fantasyTeam;
    }

    public void setFantasyTeam(FantasyTeam fantasyTeam) {
        this.fantasyTeam = fantasyTeam;
    }

    public Integer getId() {
        return id;
    }

}
