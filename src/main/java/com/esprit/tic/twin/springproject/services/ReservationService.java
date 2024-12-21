package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.entities.Etudiant;
import com.esprit.tic.twin.springproject.entities.Reservation;
import com.esprit.tic.twin.springproject.repositories.ChambreRepository;
import com.esprit.tic.twin.springproject.repositories.EtudiantRepository;
import com.esprit.tic.twin.springproject.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ReservationService implements IReservationService{
    private final EtudiantRepository etudiantRepository;
    private final ChambreRepository chambreRepository;
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
    public List<Reservation> getReservationParAnneeUniversitaire(LocalDate dateDebut, LocalDate dateFin) {
        return reservationRepository.findByAnneeUniversitaireBetween(dateDebut,dateFin);
    }

    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, long cin) {
        Etudiant etudiant = etudiantRepository.findByCin(cin);
        Chambre chambre = chambreRepository.findByNumeroChambre(numChambre);
        long reservations = chambre.getReservations().stream()
                .filter(reservation -> reservation.getAnneeUniversitaire().getYear()==(LocalDate.now().getYear())
                        && reservation.isEstValide())
                .count();
        int Capacity = switch (chambre.getTypeC()) {
            case SIMPLE -> 1 - (int) reservations;
            case DOUBLE -> 2- (int) reservations;
            default -> 3- (int) reservations;
        };
        if(res.isEstValide() && Capacity>0){
            String generatedId = numChambre.toString() + cin + LocalDate.now().getYear();
            res.setIdReservation(generatedId);

            reservationRepository.save(res);
            chambre.getReservations().add(res);
            chambreRepository.save(chambre);
            etudiant.getReservations().add(res);
            etudiantRepository.save(etudiant);
        }
        return res;
    }
}
