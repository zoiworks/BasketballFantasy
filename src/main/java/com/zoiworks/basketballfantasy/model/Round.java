package com.zoiworks.basketballfantasy.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Αντιπροσωπεύει μία αγωνιστική (γύρο) ενός πρωταθλήματος.
 * Περιλαμβάνει χρονικά όρια, αγώνες που ανήκουν σε αυτήν
 * και τις μεταγραφές fantasy ομάδων που έγιναν μέσα σε αυτή την αγωνιστική.
 */
@Entity
@Table(name = "ROUND")
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό αγωνιστικής (Primary Key)
    private Integer id;

    @Column(name = "ROUND_NUMBER", nullable = false)
    // Αριθμός αγωνιστικής (π.χ. 1, 2, 3...)
    private Integer roundNumber;

    @Column(name = "START_DATE", nullable = false)
    // Ημερομηνία έναρξης της αγωνιστικής
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    // Ημερομηνία λήξης της αγωνιστικής
    private LocalDate endDate;

    @Column(name = "START_TIME", nullable = false)
    // Ώρα έναρξης (π.χ. για κλείδωμα αλλαγών στη fantasy ομάδα)
    private LocalTime startTime;

    @Column(name = "END_TIME", nullable = false)
    // Ώρα λήξης (π.χ. όταν τελειώνουν όλοι οι αγώνες της αγωνιστικής)
    private LocalTime endTime;

    @Column(name = "STATUS")
    // Κατάσταση αγωνιστικής: true = ενεργή / false = ολοκληρωμένη
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;    

    @OneToMany(mappedBy = "round", cascade = CascadeType.ALL)
    // Αγώνες που ανήκουν σε αυτή την αγωνιστική
    private List<Game> games;

    @OneToMany(mappedBy = "round")
    // Μεταγραφές fantasy ομάδων που έγιναν σε αυτή την αγωνιστική
    private List<FantasyTeamTrades> trades;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Integer roundNumber) {
        this.roundNumber = roundNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<FantasyTeamTrades> getTrades() {
        return trades;
    }

    public void setTrades(List<FantasyTeamTrades> trades) {
        this.trades = trades;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

}
