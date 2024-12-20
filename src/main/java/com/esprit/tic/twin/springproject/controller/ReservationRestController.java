package com.esprit.tic.twin.springproject.controller;

import com.esprit.tic.twin.springproject.entities.Etudiant;
import com.esprit.tic.twin.springproject.entities.Reservation;
import com.esprit.tic.twin.springproject.services.IEtudiantService;
import com.esprit.tic.twin.springproject.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationRestController {
    IReservationService reservationService;
    // http://localhost:8090/projet/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listreservations = reservationService.retrieveAllReservations();
        if(listreservations.isEmpty()) {
            return null;
        }else return listreservations;
    }
    // http://localhost:8090/projet/reservation/par-annee-universitaire
    @GetMapping("/par-annee-universitaire")
    public List<Reservation> getReservationsParAnneeUniversitaire(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDebut,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFin) {
        return reservationService.getReservationParAnneeUniversitaire(dateDebut, dateFin);
    }

    // http://localhost:8090/projet/reservation/par-annee-universitaire
    @PostMapping("/res-chambre-etudiant")
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(
            @RequestBody Reservation reservation, @RequestParam Long numChambre, @RequestParam Long cin) {
        return reservationService.ajouterReservationEtAssignerAChambreEtAEtudiant(reservation, numChambre, cin);
    }


}
