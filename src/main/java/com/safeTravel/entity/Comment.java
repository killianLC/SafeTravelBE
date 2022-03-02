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

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne
    private City city;
}
