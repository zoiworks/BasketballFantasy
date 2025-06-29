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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



/**
 * Αντιπροσωπεύει έναν προπονητή που ανήκει σε μία πραγματική ομάδα
 * και μπορεί να συμμετέχει και σε φανταστικές ομάδες μέσω του FantasyCoach.
 */
@Entity
@Table(name = "COACH")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό προπονητή (Primary Key)
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 100)
    // Όνομα προπονητή
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", nullable = false, unique = true)
    // Ομάδα στην οποία ανήκει ο προπονητής (μία προς μία σχέση)
    private Team team;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, orphanRemoval = true)
    // Συμμετοχές του προπονητή σε φανταστικές ομάδες
    private List<FantasyCoach> fantasyCoaches;

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

    public List<FantasyCoach> getFantasyCoaches() {
        return fantasyCoaches;
    }

    public void setFantasyCoaches(List<FantasyCoach> fantasyCoaches) {
        this.fantasyCoaches = fantasyCoaches;
    }
}
