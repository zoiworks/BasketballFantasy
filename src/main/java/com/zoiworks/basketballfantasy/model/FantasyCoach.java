package com.zoiworks.basketballfantasy.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


/**
 * Αντιπροσωπεύει τον προπονητή μιας φανταστικής ομάδας. 
 * Ο προπονητής συνδέεται με μια πραγματική ομάδα (Team) και την φανταστική ομάδα (FantasyTeam).
 * Το PIR του προπονητή ενημερώνεται με βάση την απόδοση της ομάδας του.
 */
@Entity
@Table(name = "FANTASY_COACH")
public class FantasyCoach {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FANTASY_TEAM_ID", nullable = false, unique = true)
    private FantasyTeam fantasyTeam; // Η φανταστική ομάδα στην οποία ανήκει ο προπονητής

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "STATUS", nullable = false)
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COACH_ID", nullable = false)
    private Coach coach; // Ο πραγματικός προπονητής

    @Column(name = "POINTS", nullable = false)
    private Integer points = 0; // Πόντοι του προπονητή στην φανταστική ομάδα

    // public void updatePointsFromWinningTeam(Team winningTeam) {
    //     if (this.coach.getTeam().equals(winningTeam)) {
    //         this.points += 10; // Αν κερδίζει η ομάδα του προπονητή, προσθέτουμε 10 πόντους
    //     } else {
    //         this.points -= 5; // Αν χάνει η ομάδα του, αφαιρούμε 5 πόντους
    //     }
    // }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FantasyTeam getFantasyTeam() {
        return fantasyTeam;
    }

    public void setFantasyTeam(FantasyTeam fantasyTeam) {
        this.fantasyTeam = fantasyTeam;
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

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
