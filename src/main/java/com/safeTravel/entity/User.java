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
    private String prenom;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    @Column
    @OneToMany(mappedBy = "createur", fetch = FetchType.LAZY)
    private Set<Voyage> voyages;
}