package com.esprit.tic.twin.springproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
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
    private LocalDate anneeUniversitaire;
    @Column(name="estValide")
    private boolean estValide;
    @ManyToMany(mappedBy="reservations", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Etudiant> etudiants;
}
