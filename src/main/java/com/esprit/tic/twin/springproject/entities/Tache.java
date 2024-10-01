package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table( name = "Tache")
public class Tache implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTache")
    private long idTache;
    @Column(name="dateTache")
    private LocalDate dateTache;
    @Column(name="duree")
    private Integer duree;
    @Column(name="tarifHoraire")
    private Float tarifHoraire;
    @Enumerated(EnumType.STRING)
    @Column(name = "typeTache")
    private TypeTache typeTache;
    @ManyToOne
    Etudiant etudiant;
}
