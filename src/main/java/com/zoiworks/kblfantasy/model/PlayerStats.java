package com.zoiworks.kblfantasy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Αντιπροσωπεύει τα στατιστικά ενός παίκτη σε έναν συγκεκριμένο αγώνα.
 * Περιλαμβάνει λεπτομέρειες όπως πόντοι, λεπτά συμμετοχής, ριμπάουντ, ασίστ, σουτ κλπ.
 */
@Entity
@Table(name = "PLAYER_STATS")
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό των στατιστικών (Primary Key)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLAYER_ID", nullable = false)
    // Ο παίκτης στον οποίο ανήκουν αυτά τα στατιστικά
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GAME_ID", nullable = false)
    // Ο αγώνας στον οποίο καταγράφηκαν τα στατιστικά
    private Game game;

    @Column(name = "MINUTES_PLAYED")
    // Λεπτά συμμετοχής
    private Integer minutesPlayed;

    @Column(name = "POINTS")
    // Πόντοι που πέτυχε
    private Integer points;

    // Ριμπάουντ
    @Column(name = "DEF_REB")
    private Integer defensiveRebounds;

    @Column(name = "OFF_REB")
    private Integer offensiveRebounds;

    @Column(name = "TOTAL_REBOUNDS")
    private Integer totalRebounds;

    // Άλλα στατιστικά
    @Column(name = "ASSISTS")
    private Integer assists;

    @Column(name = "STEALS")
    private Integer steals;

    @Column(name = "BLOCKS")
    private Integer blocks;

    @Column(name = "TURNOVERS")
    private Integer turnovers;

    @Column(name = "FOULS")
    private Integer fouls;

    // Σουτ 2 πόντων
    @Column(name = "TWO_POINTS_MADE")
    private Integer twoPointsMade;

    @Column(name = "TWO_POINTS_MISSED")
    private Integer twoPointsMissed;

    @Column(name = "TWO_POINT_PERCENT")
    private Float twoPointPercent;

    // Σουτ 3 πόντων
    @Column(name = "THREE_POINTS_MADE")
    private Integer threePointsMade;

    @Column(name = "THREE_POINTS_MISSED")
    private Integer threePointsMissed;

    @Column(name = "THREE_POINT_PERCENT")
    private Float threePointPercent;

    // Βολές
    @Column(name = "FREE_THROWS_MADE")
    private Integer freeThrowsMade;

    @Column(name = "FREE_THROWS_MISSED")
    private Integer freeThrowsMissed;

    @Column(name = "FREE_THROW_PERCENT")
    private Float freeThrowPercent;

    // PIR ή συνολική απόδοση
    @Column(name = "EFFICIENCY")
    private Float efficiency;

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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Integer minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(Integer defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public Integer getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(Integer offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    public Integer getTotalRebounds() {
        return totalRebounds;
    }

    public void setTotalRebounds(Integer totalRebounds) {
        this.totalRebounds = totalRebounds;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getSteals() {
        return steals;
    }

    public void setSteals(Integer steals) {
        this.steals = steals;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(Integer turnovers) {
        this.turnovers = turnovers;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getTwoPointsMade() {
        return twoPointsMade;
    }

    public void setTwoPointsMade(Integer twoPointsMade) {
        this.twoPointsMade = twoPointsMade;
    }

    public Integer getTwoPointsMissed() {
        return twoPointsMissed;
    }

    public void setTwoPointsMissed(Integer twoPointsMissed) {
        this.twoPointsMissed = twoPointsMissed;
    }

    public Integer getThreePointsMade() {
        return threePointsMade;
    }

    public void setThreePointsMade(Integer threePointsMade) {
        this.threePointsMade = threePointsMade;
    }

    public Integer getThreePointsMissed() {
        return threePointsMissed;
    }

    public void setThreePointsMissed(Integer threePointsMissed) {
        this.threePointsMissed = threePointsMissed;
    }

    public Float getThreePointPercent() {
        return threePointPercent;
    }

    public void setThreePointPercent(Float threePointPercent) {
        this.threePointPercent = threePointPercent;
    }

    public Integer getFreeThrowsMade() {
        return freeThrowsMade;
    }

    public void setFreeThrowsMade(Integer freeThrowsMade) {
        this.freeThrowsMade = freeThrowsMade;
    }

    public Integer getFreeThrowsMissed() {
        return freeThrowsMissed;
    }

    public void setFreeThrowsMissed(Integer freeThrowsMissed) {
        this.freeThrowsMissed = freeThrowsMissed;
    }

    public Float getFreeThrowPercent() {
        return freeThrowPercent;
    }

    public void setFreeThrowPercent(Float freeThrowPercent) {
        this.freeThrowPercent = freeThrowPercent;
    }

    public Float getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Float efficiency) {
        this.efficiency = efficiency;
    }

    public Float getTwoPointPercent() {
        return twoPointPercent;
    }

    public void setTwoPointPercent(Float twoPointPercent) {
        this.twoPointPercent = twoPointPercent;
    }

}
