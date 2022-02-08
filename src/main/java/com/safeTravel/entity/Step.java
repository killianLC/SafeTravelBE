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
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private int stepNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;
}
