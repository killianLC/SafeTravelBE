package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Criterion {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String type;

    @Column
    private String libelle;

    @OneToMany(mappedBy = "criterion")
    private Set<Note> notes;
}
