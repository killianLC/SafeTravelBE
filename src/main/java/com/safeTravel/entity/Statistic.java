package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Statistic {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    private City city;

    @Column
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Criterion> criteria;
}
