package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Ville {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String nom;

    @Column
    @OneToMany()
    private Set<Etape> etapes;

    @Column
    @OneToMany()
    private Set<Commentaire> commentaires;
}
