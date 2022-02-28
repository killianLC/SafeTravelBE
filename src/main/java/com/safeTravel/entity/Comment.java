package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate date;

    @Column
    private Integer rating;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;
}
