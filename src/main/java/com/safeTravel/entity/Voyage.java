package com.safeTravel.entity;

import com.safeTravel.dto.VilleDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
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
    private LocalDate dateDebut;
    @Column
    private LocalDate dateFin;
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
