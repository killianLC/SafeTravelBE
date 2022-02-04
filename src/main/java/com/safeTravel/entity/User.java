package com.safeTravel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
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

    @Column
    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    @Column
    @OneToMany(mappedBy = "organizer", fetch = FetchType.LAZY)
    private Set<Trip> trips;
}