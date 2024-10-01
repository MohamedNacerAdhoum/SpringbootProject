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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    private Set<Tache> tacheSet;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
