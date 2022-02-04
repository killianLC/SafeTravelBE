package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Critere {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    @OneToMany()
    private Set<Step> steps;

    @Column
    @OneToMany()
    private Set<Statistic> statistics;
}
