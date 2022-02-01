package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table
@Entity
public class Etape {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private LocalDate dateDebut;

    @Column
    private LocalDate dateFin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ville ville;

    @ManyToOne(fetch = FetchType.LAZY)
    private Voyage voyage;
}
