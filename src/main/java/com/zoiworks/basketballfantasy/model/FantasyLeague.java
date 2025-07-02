package com.zoiworks.basketballfantasy.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
 * Αντιπροσωπεύει ένα φανταστικό πρωτάθλημα στο οποίο συμμετέχουν χρήστες με τις
 * ομάδες τους.
 * Συνδέεται με ένα πραγματικό πρωτάθλημα (π.χ. Euroleague) και έχει δημιουργό.
 */
@Entity
@Table(name = "FANTASY_LEAGUE")
public class FantasyLeague {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό του fantasy πρωταθλήματος
    private Integer id;

    @Column(nullable = false, length = 100)
    // Όνομα του fantasy πρωταθλήματος (π.χ. "Λίγκα Γιώργου")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEAGUE_ID", nullable = false)
    // Το πραγματικό πρωτάθλημα στο οποίο βασίζεται (π.χ. Euroleague)
    private Competition competition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID", nullable = false)
    // Ο χρήστης που δημιούργησε το fantasy πρωτάθλημα
    private User creator;

    @Column(nullable = false, updatable = false)
    // Ημερομηνία δημιουργίας
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    // Κατάσταση: true = ενεργό, false = κλειστό
    private Boolean status = true;

    @OneToMany(mappedBy = "fantasyLeague", cascade = CascadeType.ALL)
    // Όλες οι ομάδες που συμμετέχουν σε αυτό το πρωτάθλημα
    private List<FantasyTeam> teams = new ArrayList<>();

    // Επειδη δεν το διαβαζει το LomBok
    public void setId(Integer id) {
        this.id = id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<FantasyTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<FantasyTeam> teams) {
        this.teams = teams;
    }
}
