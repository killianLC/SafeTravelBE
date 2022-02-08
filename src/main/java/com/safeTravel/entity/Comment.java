package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    private double rating;

    @JoinColumn
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;
}
