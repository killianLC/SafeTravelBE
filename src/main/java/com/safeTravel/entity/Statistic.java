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
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @OneToMany(mappedBy = "statistic", fetch = FetchType.LAZY)
    private Set<Criterion> criteria;
}
