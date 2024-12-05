package com.esprit.tic.twin.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Foyer foyer;
}
