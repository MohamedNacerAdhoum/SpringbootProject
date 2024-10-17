package com.esprit.tic.twin.springproject.controller;

import com.esprit.tic.twin.springproject.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ReservationRestController {
    IReservationService reservationService;
}
