package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Travel {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @JoinColumn
    @OneToOne()
    private Trip trip;

    @Column
    @ManyToMany(mappedBy = "travels")
    private Set<User> users;

    @Column
    private Boolean isOrganizer;
}
