package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Trip {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String description;

    @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Step> steps;

    @JoinColumn(name = "organisateur_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User organisateur;

    @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY)
    private Set<Participant> participants;
}
