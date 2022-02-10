package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Comment {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String description;

    @Column
    private Double rating;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;
}
