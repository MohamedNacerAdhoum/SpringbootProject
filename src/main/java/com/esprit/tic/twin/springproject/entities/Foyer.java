package com.esprit.tic.twin.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Foyer")
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFoyer")
    private long idFoyer;
    @Column(name="nomFoyer")
    private String nomFoyer;
    @Column(name="capaciteFoyer")
    private long capaciteFoyer;
    @OneToOne(mappedBy = "foyer")
    @JsonIgnore
    private Universite universite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
    @JsonIgnore
    private Set<Bloc> blocs;
}
