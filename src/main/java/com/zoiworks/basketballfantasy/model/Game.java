package com.zoiworks.basketballfantasy.model;

import java.time.LocalDate;
import java.time.LocalTime;
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
 * Αντιπροσωπεύει έναν αγώνα ανάμεσα σε δύο ομάδες, εντός μιας συγκεκριμένης
 * αγωνιστικής (Round).
 * Περιλαμβάνει ημερομηνία διεξαγωγής, σκορ και όλα τα στατιστικά του αγώνα.
 */
@Entity
@Table(name = "GAME")
public class Game {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό αγώνα (Primary Key)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROUND_ID", nullable = false)
    // Η αγωνιστική (Round) στην οποία ανήκει ο αγώνας
    private Round round;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOME_TEAM_ID", nullable = false)
    // Η ομάδα που παίζει εντός έδρας
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AWAY_TEAM_ID", nullable = false)
    // Η ομάδα που παίζει εκτός έδρας
    private Team awayTeam;

    @Column(name = "GAME_DATE", nullable = false)
    // Ημερομηνία διεξαγωγής του αγώνα
    private LocalDate gameDate;

    @Column(name = "SCORE_HOME")
    // Πόντοι της γηπεδούχου ομάδας
    private Integer scoreHome;

    @Column(name = "SCORE_AWAY")
    // Πόντοι της φιλοξενούμενης ομάδας
    private Integer scoreAway;

    @Column(name = "START_TIME")
    private java.time.LocalTime startTime;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    // Τα στατιστικά των παικτών σε αυτόν τον αγώνα
    private List<PlayerStats> stats;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public Integer getScoreHome() {
        return scoreHome;
    }

    public void setScoreHome(Integer scoreHome) {
        this.scoreHome = scoreHome;
    }

    public Integer getScoreAway() {
        return scoreAway;
    }

    public void setScoreAway(Integer scoreAway) {
        this.scoreAway = scoreAway;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public List<PlayerStats> getStats() {
        return stats;
    }

    public void setStats(List<PlayerStats> stats) {
        this.stats = stats;
    }
}
