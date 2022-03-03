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

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Set<Step> steps;

    @JoinColumn(name = "organisateur_id", referencedColumnName = "id")
    @ManyToOne
    private User organisateur;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.REMOVE)
    private Set<Participant> participants;
}
