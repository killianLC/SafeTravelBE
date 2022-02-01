package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Statistique {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Double noteSafeTravel;

    @Column
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Critere> criteres;
}
