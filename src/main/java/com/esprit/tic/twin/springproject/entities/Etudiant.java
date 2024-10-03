package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private long idEtudiant;
    @Column(name="nomEt")
    private String nomEt;
    @Column(name="prenomEt")
    private String prenomEt;
    @Column(name="cin")
    private long cin;
    @Column(name="ecole")
    private String ecole;
    @Column(name="dateNaissance")
    private Date edateNaissancecole;
    @Enumerated(EnumType.STRING)
    @Column(name = "typeEtudiant")
    private TypeEtudiant typeEtudiant;
    @OneToMany(mappedBy = "etudiants")
    private Set<Tache> taches;
    @ManyToMany
    private Set<Reservation> reservations;
    @OneToOne
    private Tache tache;

}
