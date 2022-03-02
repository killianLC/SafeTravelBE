package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Participant {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    @ManyToOne
    private Trip trip;

    @Column
    private Boolean statut = false;
}
