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

    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne
    private City city;

    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    @ManyToOne
    private Trip trip;
}
