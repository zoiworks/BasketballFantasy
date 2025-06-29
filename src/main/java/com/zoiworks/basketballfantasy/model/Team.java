package com.zoiworks.basketballfantasy.model;

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
 * Αντιπροσωπεύει μία πραγματική ομάδα μπάσκετ που συμμετέχει σε πρωτάθλημα.
 * Συνδέεται με παίκτες, προπονητή και αγώνες (εντός και εκτός έδρας).
 */
@Entity
@Table(name = "TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό ομάδας (Primary Key)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 100, unique = true)
    // Όνομα ομάδας (μοναδικό)
    private String title;

    @Column(name = "PHOTO_URL", length = 255)
    // URL για το λογότυπο ή τη φωτογραφία της ομάδας
    private String photoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_id", nullable = false)
    // Το πρωτάθλημα στο οποίο συμμετέχει η ομάδα
    private Competition competition;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    // Οι παίκτες που ανήκουν στην ομάδα
    private List<Player> players;

    @OneToMany(mappedBy = "homeTeam", cascade = CascadeType.REMOVE)
    // Οι αγώνες που η ομάδα είναι γηπεδούχος
    private List<Game> homeGames;

    @OneToMany(mappedBy = "awayTeam", cascade = CascadeType.REMOVE)
    // Οι αγώνες που η ομάδα είναι φιλοξενούμενη
    private List<Game> awayGames;

    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    // Ο προπονητής της ομάδας
    private Coach coach;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Game> getHomeGames() {
        return homeGames;
    }

    public void setHomeGames(List<Game> homeGames) {
        this.homeGames = homeGames;
    }

    public List<Game> getAwayGames() {
        return awayGames;
    }

    public void setAwayGames(List<Game> awayGames) {
        this.awayGames = awayGames;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

}
