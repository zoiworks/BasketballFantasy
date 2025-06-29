package com.zoiworks.basketballfantasy.model;

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

@Entity
@Table(name = "CHAMPIONSHIP")
public class Championship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό διοργάνωσης
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 100)
    // Όνομα διοργάνωσης (π.χ. Euroleague, Πανελλήνιο U18)
    private String name;

    @Column(name = "PHOTO_URL", length = 255)
    // URL για λογότυπο διοργάνωσης
    private String photoUrl;

    @OneToMany(mappedBy = "championship", cascade = CascadeType.ALL, orphanRemoval = true)
    // Πρωταθλήματα που ανήκουν στη διοργάνωση
    private List<Competition> competitions;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    // Getters, setters, constructors

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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
