package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation(Reservation f);
    Reservation updateReservation(Reservation f);
    Reservation retrieveReservation(String idReservation);
    void removeReservation(String idReservation);

    List<Reservation> getReservationParAnneeUniversitaire(LocalDate dateDebut, LocalDate dateFin);

    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, long cin) ;
}
