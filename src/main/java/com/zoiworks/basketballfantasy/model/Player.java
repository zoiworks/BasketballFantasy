package com.zoiworks.basketballfantasy.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Αντιπροσωπεύει έναν πραγματικό παίκτη μπάσκετ που ανήκει σε μία ομάδα,
 * έχει συγκεκριμένη θέση, αριθμό φανέλας και φωτογραφία.
 * Συμμετέχει σε αγώνες και σε fantasy ομάδες.
 */

@Entity
@Table(name = "PLAYER")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό παίκτη (Primary Key)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 100)
    // Όνομα παίκτη
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", nullable = false)
    // Ομάδα στην οποία ανήκει ο παίκτης
    private Team team;

    @Enumerated(EnumType.STRING)
    @Column(name = "POSITION", length = 50)
    // Θέση του παίκτη στο γήπεδο (GUARD, FORWARD, CENTER)
    private Position position;

    @Column(name = "NUMBER")
    // Αριθμός φανέλας του παίκτη
    private Integer number;

    @Column(name = "PHOTO_URL", length = 255)
    // URL φωτογραφίας παίκτη (π.χ. για εμφάνιση στο front-end)
    private String photoUrl;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    // Στατιστικά που έχει ο παίκτης ανά αγώνα
    private List<PlayerStats> playerstats;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    // Οι εμφανίσεις του παίκτη σε fantasy ομάδες (συμμετοχές)
    private List<FantasyPlayer> fantasyPlayers;

    /**
     * Θέση παίκτη στο γήπεδο.
     */
    public enum Position {
        GUARD,
        FORWARD,
        CENTER
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<PlayerStats> getPlayerstats() {
        return playerstats;
    }

    public void setPlayerstats(List<PlayerStats> playerstats) {
        this.playerstats = playerstats;
    }

    public List<FantasyPlayer> getFantasyPlayers() {
        return fantasyPlayers;
    }

    public void setFantasyPlayers(List<FantasyPlayer> fantasyPlayers) {
        this.fantasyPlayers = fantasyPlayers;
    }

}
