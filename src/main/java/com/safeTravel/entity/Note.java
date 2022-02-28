package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table
public class Note {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Double note;

    @Column
    private LocalDate date;

    @JoinColumn(name = "city_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @JoinColumn(name = "criterion_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Criterion criterion;
}
