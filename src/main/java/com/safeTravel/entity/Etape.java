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
    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ville_id", referencedColumnName = "id")
    private Ville ville;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="voyage_id", referencedColumnName = "id")
    private Voyage voyage;
}
