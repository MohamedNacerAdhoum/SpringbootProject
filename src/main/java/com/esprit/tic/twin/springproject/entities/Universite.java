package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table( name = "Universite")
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniversite")
    private long idUniversite;
    @Column(name="nomUniversite")
    private String nomUniversite;
    @Column(name="adresse")
    private String adresse;
    @OneToOne
    private Foyer foyer;
}
