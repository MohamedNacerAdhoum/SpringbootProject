package com.esprit.tic.twin.springproject.repositories;

import com.esprit.tic.twin.springproject.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
