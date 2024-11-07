package com.esprit.tic.twin.springproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @Column(name="idReservation")
    private String idReservation;
    @Column(name="anneeUniversitaire")
    private Date anneeUniversitaire;
    @Column(name="estValide")
    private boolean estValide;
    @ManyToMany(mappedBy="reservations")
    private Set<Etudiant> etudiants;
}
