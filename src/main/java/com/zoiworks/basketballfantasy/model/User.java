package com.zoiworks.basketballfantasy.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;



@Entity
@Table(name = "APP_USERS", uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    // Μοναδικό αναγνωριστικό χρήστη (Primary Key)
    private int id;

    @Column(name = "EMAIL", nullable = false, length = 150, unique = true)
    // Email του χρήστη (χρησιμοποιείται και για login) – μοναδικό
    private String email;

    @JsonIgnore
    @Column(name = "PASSWORD", nullable = false, length = 255)
    // Κρυπτογραφημένο password (hash)
    private String password;

    @Column(name = "FIRST_NAME", nullable = true, length = 100)
    // Όνομα
    private String firstName;

    @Column(name = "LAST_NAME", nullable = true, length = 100)
    // Επώνυμο
    private String lastName;

    @Column(name = "DATE_OF_BIRTH", nullable = true)
    // Ημερομηνία γέννησης
    private LocalDate dateOfBirth;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    @Column(name = "STATUS", nullable = false)
    // Αν ο λογαριασμός είναι ενεργός (true/false)
    private Boolean status = true;

    @Column(name = "PROFILE_PICTURE_URL", length = 255)
    // URL για φωτογραφία προφίλ (προαιρετικά)
    private String profilePictureUrl;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    // Ημερομηνία δημιουργίας λογαριασμού
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "UPDATED_AT")
    // Τελευταία ενημέρωση στοιχείων
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FantasyTeam> fantasyTeams = new ArrayList<>();

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    // Λίστα με τα fantasy πρωταθλήματα που έχει δημιουργήσει ο χρήστης
    private List<FantasyLeague> createdLeagues = new ArrayList<>();

    // Constructors, Getters, Setters, toString...
    public boolean canCreateNewFantasyTeam() {
        return fantasyTeams.size() < 3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<FantasyLeague> getCreatedLeagues() {
        return createdLeagues;
    }

    public void setCreatedLeagues(List<FantasyLeague> createdLeagues) {
        this.createdLeagues = createdLeagues;
    }

    public List<FantasyTeam> getFantasyTeams() {
        return fantasyTeams;
    }

    public void setFantasyTeams(List<FantasyTeam> fantasyTeams) {
        this.fantasyTeams = fantasyTeams;
    }

}
