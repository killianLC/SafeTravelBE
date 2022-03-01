package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table
@Entity
public class Step {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private LocalDate date;

    @JoinColumn(name = "city_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private City city;

    @JoinColumn(name = "trip_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;
}
