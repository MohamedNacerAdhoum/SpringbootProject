package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "Bloc")
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBloc")
    private long idBloc;
    @Column(name="nomBloc")
    private String nomBloc;
    @Column(name="capaciteBloc")
    private long capaciteBloc;
    @ManyToOne
    private Foyer foyer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    private Set<Chambre> chambres;
}
