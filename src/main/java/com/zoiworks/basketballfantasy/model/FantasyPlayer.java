package com.zoiworks.basketballfantasy.model;

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
import jakarta.persistence.Table;

/**
 * Αντιπροσωπεύει έναν παίκτη που ανήκει σε μία φανταστική ομάδα (FantasyTeam),
 * βασίζεται σε έναν πραγματικό παίκτη (Player), και έχει συγκεκριμένο ρόλο
 * (βασικός ή πάγκος) μέσα στη σύνθεση της ομάδας.
 */

@Entity
@Table(name = "FANTASY_PLAYER")
public class FantasyPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό του fantasy παίκτη
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLAYER_ID", nullable = false)
    // Ο πραγματικός παίκτης στον οποίο βασίζεται
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FANTASY_TEAM_ID", nullable = false)
    // Η φανταστική ομάδα στην οποία ανήκει ο παίκτης
    private FantasyTeam fantasyTeam;

    @ManyToOne
    @JoinColumn(name = "fantasy_team_history_id")
    private FantasyTeamHistory fantasyTeamHistory;

    @Enumerated(EnumType.STRING)
    @Column(name = "REAL_POSITION", nullable = false, length = 50)
    // Η φυσική του θέση στο γήπεδο (GUARD, FORWARD, CENTER)
    private Position realPosition;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false, length = 20)
    // Ρόλος μέσα στη fantasy ομάδα: STARTER ή BENCH
    private RoleInTeam role = RoleInTeam.STARTER;

    @Column(name = "PIR", nullable = false)
    // Οι συνολικοί πόντοι (PIR) του παίκτη στη fantasy ομάδα
    private float pir = 0.0f;

    @Column(name = "PLAYER_PRICE", nullable = false)
    // Η τιμή αγοράς του παίκτη όταν προστέθηκε στην ομάδα
    private float playerPrice;

    @Column(name = "NUMBER")
    // Αριθμός φανέλας (προαιρετικά για εμφάνιση)
    private Integer number;

    @Column(name = "PHOTO_URL", length = 255)
    // URL φωτογραφίας (προαιρετικά για εμφάνιση)
    private String photoUrl;

    @Column(name = "CAPTAIN", nullable = false)
    private boolean captain = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public FantasyTeam getFantasyTeam() {
        return fantasyTeam;
    }

    public void setFantasyTeam(FantasyTeam fantasyTeam) {
        this.fantasyTeam = fantasyTeam;
    }

    public FantasyTeamHistory getFantasyTeamHistory() {
        return fantasyTeamHistory;
    }

    public void setFantasyTeamHistory(FantasyTeamHistory fantasyTeamHistory) {
        this.fantasyTeamHistory = fantasyTeamHistory;
    }

    public Position getRealPosition() {
        return realPosition;
    }

    public void setRealPosition(Position realPosition) {
        this.realPosition = realPosition;
    }

    public RoleInTeam getRole() {
        return role;
    }

    public void setRole(RoleInTeam role) {
        this.role = role;
    }

    public float getPir() {
        return pir;
    }

    public void setPir(float pir) {
        this.pir = pir;
    }

    public float getPlayerPrice() {
        return playerPrice;
    }

    public void setPlayerPrice(float playerPrice) {
        this.playerPrice = playerPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean isCaptain() {
        return captain;
    }

    public void setCaptain(boolean captain) {
        this.captain = captain;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public enum RoleInTeam {
        STARTER,
        BENCH
    }

    public enum Position {
        GUARD,
        FORWARD,
        CENTER
    }

}
