package com.zoiworks.basketballfantasy.model;

import java.time.LocalDate;
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
 * Αντιπροσωπεύει ένα πρωτάθλημα στο οποίο συμμετέχουν ομάδες και παίζονται
 * αγώνες.
 * Περιλαμβάνει βασικές πληροφορίες, ημερομηνίες, και συσχετίσεις με ομάδες και
 * γύρους.
 */
@Entity
@Table(name = "COMPETITION")
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό πρωταθλήματος (Primary Key)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    // Σύνδεση με τον manager-user
    private User manager;

    @Column(name = "SEASON", length = 9)
    // Περίοδος/σεζόν του πρωταθλήματος (π.χ. 2024-2025)
    private String season;

    @Column(name = "NAME", nullable = false, length = 100)
    // Όνομα του πρωταθλήματος
    private String name;

    @Column(name = "CATEGORY", length = 50)
    // Κατηγορία πρωταθλήματος (π.χ. Ανδρών, Γυναικών, U18)
    private String category;

    @Column(name = "NUMBER_OF_TEAMS")
    // Συνολικός αριθμός ομάδων που συμμετέχουν
    private Integer numberOfTeams;

    @Column(name = "START_DATE")
    // Ημερομηνία έναρξης του πρωταθλήματος
    private LocalDate startDate;

    @Column(name = "END_DATE")
    // Ημερομηνία λήξης του πρωταθλήματος
    private LocalDate endDate;

    @Column(name = "STATUS")
    // Κατάσταση (ενεργό/ολοκληρωμένο) – true = ενεργό
    private Boolean status;

    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL, orphanRemoval = true)
    // Οι ομάδες που συμμετέχουν στο πρωτάθλημα
    private List<Team> teams;

    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL, orphanRemoval = true)
    // Οι αγωνιστικές (γύροι) του πρωταθλήματος
    private List<Round> rounds;

    @Column(name = "PHOTO_URL", length = 255)
    // URL για το λογότυπο ή τη φωτογραφία της ομάδας
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "championship_id")
    private Championship championship;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(Integer numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }
}
