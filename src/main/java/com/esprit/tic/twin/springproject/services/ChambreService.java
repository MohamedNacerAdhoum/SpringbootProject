package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.entities.Etudiant;
import com.esprit.tic.twin.springproject.entities.Reservation;
import com.esprit.tic.twin.springproject.entities.TypeChambre;
import com.esprit.tic.twin.springproject.repositories.ChambreRepository;
import com.esprit.tic.twin.springproject.repositories.EtudiantRepository;
import com.esprit.tic.twin.springproject.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreService implements IChambreService{
    ChambreRepository chambreRepository;
    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre f) {
        return chambreRepository.save(f);
    }

    @Override
    public Chambre updateChambre(Chambre f) {
        return chambreRepository.save(f);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> findChambreByNomBlocAndTypeCKeyword(String nom, String type) {
        return chambreRepository.findByBlocNomBlocAndTypeC(nom,TypeChambre.valueOf(type));
    }

    @Override
    public List<Chambre> findChambreByNomBlocAndTypeCJPQL(String nom, String type) {
        return chambreRepository.retrieveChambreDoubleByBloc(nom,TypeChambre.valueOf(type));
    }

    @Override
    public List<Chambre> findChambreByReservationStatusKeyword(String status) {
        return chambreRepository.findByReservationsEstValide(Boolean.valueOf(status));
    }

    @Override
    public List<Chambre> findChambreByReservationStatusJPQL(String status) {
        return chambreRepository.retrieveChambreByReservation(Boolean.valueOf(status));
    }

    @Override
    public List<Chambre> findChambreByBlocNomBlocAndBlocCapaciteBlocGreaterThanKeyword(String nom, long capacite) {
        return chambreRepository.findByBlocNomBlocAndBlocCapaciteBlocGreaterThan(nom, capacite);
    }

    @Override
    public List<Chambre> findChambreByBlocNomBlocAndBlocCapaciteBlocGreaterThanJPQL(String nom, long capacite) {
        return chambreRepository.retrieveChambreDoubleByBlocAndCapacite(nom,capacite);
    }

    @Override
    public long nbChambreParTypeEtBloc(String type, long idBloc) {
        return chambreRepository.retrieveCountByTypeAndBlocId(type, idBloc);
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        return chambreRepository.findByBlocNomBloc(nomBloc);
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc){
        return chambreRepository.countChambreByTypeCAndBlocIdBloc(type, idBloc);
    }

    @Override
    public void pourcentageChambreParTypeChambre(){
        List<Chambre> chambreList = chambreRepository.findAll();
        log.info("nB Chambre total: {}", chambreList.size());
        for (TypeChambre typeChambre : TypeChambre.values()) {
            long value = ((chambreList.stream().filter(chambre -> chambre.getTypeC()==typeChambre).count())*100)/chambreList.size();
            log.info("pourcentage de chambre {} est: {}", typeChambre, value);
        }
    }


    //@Scheduled(fixedDelay = 5000)
    @Override
    public void nbPlacesDisponiblesParChambreAnneeEnCours(){
        List<Chambre> chambreList = chambreRepository.retrieveChambreByReservationAndYear(true, LocalDate.now().getYear());
        for (Chambre chambre : chambreList) {
            long reservations = chambre.getReservations().size();
            int Capacity = switch (chambre.getTypeC()) {
                case SIMPLE -> 1 - (int) reservations;
                case DOUBLE -> 2- (int) reservations;
                default -> 3- (int) reservations;
            };
            log.info("nb places restant dans chambre {} de type {} est: {}", chambre.getNumeroChambre(),chambre.getTypeC(), Capacity);
        }
    }

    @Override
    public Reservation assignChambreToEtudiant(Long cin, TypeChambre typeChambre) {
        Etudiant etudiant = etudiantRepository.findByCin(cin);
        List<Chambre> chambreList;
        if (!(typeChambre ==null)) {
            chambreList = chambreRepository.findByTypeC(typeChambre);
        } else {
            chambreList = chambreRepository.findAll();
        }

        for (Chambre chambre : chambreList) {
            long reservations = chambre.getReservations().stream()
                    .filter(reservation -> reservation.getAnneeUniversitaire().getYear()==(LocalDate.now().getYear())
                            && reservation.isEstValide()).count();
            if (typeChambre == TypeChambre.TRIPLE && reservations < 3 || typeChambre == TypeChambre.DOUBLE && reservations < 2 || typeChambre == TypeChambre.SIMPLE && reservations < 1) {
                Reservation reservation = new Reservation();
                String generatedId = String.valueOf(chambre.getNumeroChambre())+ cin + LocalDate.now().getYear();
                reservation.setIdReservation(generatedId);
                reservation.setAnneeUniversitaire(LocalDate.now());
                reservation.setEstValide(true);

                reservationRepository.save(reservation);
                chambre.getReservations().add(reservation);
                chambreRepository.save(chambre);
                etudiant.getReservations().add(reservation);
                etudiantRepository.save(etudiant);
                return reservation;
            }
        }
        return null;
    }

}
