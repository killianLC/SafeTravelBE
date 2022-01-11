package com.safeTravel.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
}