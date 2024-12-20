package com.esprit.tic.twin.springproject.repositories;

import com.esprit.tic.twin.springproject.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    List <Reservation> findByAnneeUniversitaireBetween(LocalDate debut, LocalDate fin);
}
