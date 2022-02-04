package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Trip {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    @OneToMany(mappedBy = "city")
    private Set<Step> steps;

    @Column
    @ManyToMany
    private Set<User> attendees;

    @ManyToOne(fetch = FetchType.LAZY)
    private User organizer;
}
