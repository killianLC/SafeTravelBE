package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class City {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "city")
    private Set<Comment> comments;

    @OneToMany(mappedBy = "city")
    private Set<Note> notes;

    @OneToMany(mappedBy = "city")
    private Set<Step> steps;

    @ManyToMany(mappedBy = "citiesFavoris")
    private Set<User> usersFavories;
}
