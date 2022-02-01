package com.safeTravel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Commentaire {
    @Id
    @GeneratedValue
    @Column
    private Long id;
}
