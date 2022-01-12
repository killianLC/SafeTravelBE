package com.safeTravel.entity;

import com.safeTravel.dto.CommentaireDto;
import com.safeTravel.dto.StatistiqueDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Ville {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String nom;
    @Column
    @OneToMany(mappedBy = "ville")
    private Set<Etape> etapes;
    @Column
    private List<CommentaireDto> commentaireList;
    @Column
    private StatistiqueDto statistiqueDto;
}
