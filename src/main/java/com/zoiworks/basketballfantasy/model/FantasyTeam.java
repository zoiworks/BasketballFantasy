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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Αντιπροσωπεύει μία φανταστική ομάδα που δημιουργείται από έναν χρήστη
 * και συμμετέχει σε ένα fantasy πρωτάθλημα. Περιλαμβάνει παίκτες, προπονητή,
 * πόντους, σύνθεση και άλλα μεταδεδομένα.
 */

@Entity
@Table(name = "FANTASY_TEAM")
public class FantasyTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό της fantasy ομάδας
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    // Ο χρήστης που δημιούργησε τη fantasy ομάδα
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FANTASY_LEAGUE_ID", nullable = false)
    // Το fantasy πρωτάθλημα στο οποίο συμμετέχει η ομάδα
    private FantasyLeague fantasyLeague;

    @OneToMany(mappedBy = "fantasyTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    // Οι φανταστικοί παίκτες που ανήκουν σε αυτή την ομάδα
    private List<FantasyPlayer> fantasyPlayers = new ArrayList<>();

    @OneToOne(mappedBy = "fantasyTeam", cascade = CascadeType.ALL, orphanRemoval = true)
    // Ο φανταστικός προπονητής της ομάδας
    private FantasyCoach fantasyCoach;

    @Column(name = "TITLE", nullable = true, length = 100)
    // Όνομα της ομάδας
    private String title;

    @Column(name = "TEAM_IMAGE", nullable = false, length = 255)
    // URL εικόνας της ομάδας
    private String teamImage;

    @Column(name = "CREDITS", nullable = false)
    // Υπόλοιπο budget/credits της ομάδας (π.χ. ξεκινά από 100.0)
    private Float credits = 0.0f;

    @Column(name = "PIR", nullable = false)
    // Συνολικός PIR από όλους τους παίκτες της ομάδας
    private Integer pir = 0;

    @Column(name = "CREATION_DATE", nullable = false, updatable = false)
    // Ημερομηνία δημιουργίας της ομάδας
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name = "STATUS", nullable = false)
    // Κατάσταση της ομάδας (true = ενεργή)
    private Boolean status = true;

    // Περιορισμοί θέσεων
    // Flag μεχρι 1
    @Column(name = "CENTER", nullable = false, columnDefinition = "SMALLINT DEFAULT 0")
    private Short center = 0;
    // Flag μεχρι 2
    @Column(name = "GUARD", nullable = false, columnDefinition = "SMALLINT DEFAULT 0")
    private Short guard = 0;
    // Flag μεχρι 3
    @Column(name = "FORWARD", nullable = false, columnDefinition = "SMALLINT DEFAULT 0")
    private Short forward = 0;
    // Flag μεχρι 2 Guard, 1 Forward, 1 Center
    @Column(name = "BENCH", nullable = false, columnDefinition = "SMALLINT DEFAULT 0")
    private Short bench = 0;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FantasyLeague getFantasyLeague() {
        return fantasyLeague;
    }

    public void setFantasyLeague(FantasyLeague fantasyLeague) {
        this.fantasyLeague = fantasyLeague;
    }

    public List<FantasyPlayer> getFantasyPlayers() {
        return fantasyPlayers;
    }

    public void setFantasyPlayers(List<FantasyPlayer> fantasyPlayers) {
        this.fantasyPlayers = fantasyPlayers;
    }

    public FantasyCoach getFantasyCoach() {
        return fantasyCoach;
    }

    public void setFantasyCoach(FantasyCoach fantasyCoach) {
        this.fantasyCoach = fantasyCoach;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeamImage() {
        return teamImage;
    }

    public void setTeamImage(String teamImage) {
        this.teamImage = teamImage;
    }

    public Float getCredits() {
        return credits;
    }

    public void setCredits(Float credits) {
        this.credits = credits;
    }

    public Integer getPir() {
        return pir;
    }

    public void setPir(Integer pir) {
        this.pir = pir;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Short getCenter() {
        return center;
    }

    public void setCenter(Short center) {
        this.center = center;
    }

    public Short getGuard() {
        return guard;
    }

    public void setGuard(Short guard) {
        this.guard = guard;
    }

    public Short getForward() {
        return forward;
    }

    public void setForward(Short forward) {
        this.forward = forward;
    }

    public Short getBench() {
        return bench;
    }

    public void setBench(Short bench) {
        this.bench = bench;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
