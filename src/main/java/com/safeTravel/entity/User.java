package com.safeTravel.entity;

import lombok.*;

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

    @JoinColumn
    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    @JoinColumn
    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Travel> travels;

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}