package com.esprit.tic.twin.springproject.entities;

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
@Table( name = "Chambre")
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idChambre")
    private long idChambre;
    @Column(name="numeroChambre")
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    @Column(name = "typeC")
    private TypeChambre typeC;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
    @ManyToOne
    private Bloc bloc;
}
