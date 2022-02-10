package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Travel {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @JoinColumn(name = "trip_id")
    @ManyToOne
    private Trip trip;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
}
