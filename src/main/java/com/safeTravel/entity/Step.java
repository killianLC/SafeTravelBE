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

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Trip trip;
}
