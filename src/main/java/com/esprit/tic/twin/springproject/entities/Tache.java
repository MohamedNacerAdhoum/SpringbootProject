package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    Etudiant etudiants;
    @OneToOne(mappedBy="tache")
    private Etudiant etudiant;

}
