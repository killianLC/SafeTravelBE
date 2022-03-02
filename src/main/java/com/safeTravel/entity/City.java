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

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<Note> notes;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<Step> steps;
}
