package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table
public class Voyage {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    @OneToMany(mappedBy = "ville")
    private Set<Etape> etapes;
    @Column
    @ManyToMany
    private Set<User> participants;
    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createur_id", referencedColumnName = "id")
    private User createur;
}
