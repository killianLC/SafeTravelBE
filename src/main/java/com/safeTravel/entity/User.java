package com.safeTravel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<Participant> participations;

    @OneToMany(mappedBy = "organisateur")
    private Set<Trip> trips;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    @ManyToMany
    @JoinTable(name = "user_favoris_ville",
            joinColumns = @JoinColumn(name = "ville_favoris_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<City> citiesFavoris;

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}