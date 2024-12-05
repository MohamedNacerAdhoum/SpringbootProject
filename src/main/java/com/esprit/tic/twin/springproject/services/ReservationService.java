package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Reservation;
import com.esprit.tic.twin.springproject.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ReservationService implements IReservationService{
    ReservationRepository reservationRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation f) {
        return reservationRepository.save(f);
    }

    @Override
    public Reservation updateReservation(Reservation f) {
        return reservationRepository.save(f);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin) {
        return reservationRepository.findByAnneeUniversitaireBetween(dateDebut,dateFin);
    }
}
