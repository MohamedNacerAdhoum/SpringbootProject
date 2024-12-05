package com.esprit.tic.twin.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name="montantInscription ",nullable = false)
    private float montantInscription = 500;
    @Enumerated(EnumType.STRING)
    @Column(name = "typeEtudiant")
    private TypeEtudiant typeEtudiant;
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Tache> taches;
    @ManyToMany
    @JsonIgnore
    private Set<Reservation> reservations;
}
