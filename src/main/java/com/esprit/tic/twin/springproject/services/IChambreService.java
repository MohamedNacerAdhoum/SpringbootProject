package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.entities.Reservation;
import com.esprit.tic.twin.springproject.entities.TypeChambre;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre f);
    Chambre updateChambre(Chambre f);
    Chambre retrieveChambre(Long idChambre);
    void removeChambre(Long idChambre);

    // JPQL Keyword
    List<Chambre> findChambreByNomBlocAndTypeCKeyword(String nom, String type);
    List<Chambre> findChambreByNomBlocAndTypeCJPQL(String nom, String type);
    List<Chambre> findChambreByReservationStatusKeyword(String status);
    List<Chambre> findChambreByReservationStatusJPQL(String status);
    List<Chambre> findChambreByBlocNomBlocAndBlocCapaciteBlocGreaterThanKeyword(String nom, long capacite);
    List<Chambre> findChambreByBlocNomBlocAndBlocCapaciteBlocGreaterThanJPQL(String nom, long capacite);

    long nbChambreParTypeEtBloc(String type, long idBloc);

    List<Chambre> getChambresParNomBloc(String nomBloc) ;

    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;

    //@Scheduled(fixedDelay = 5000)
    void pourcentageChambreParTypeChambre();

    @Scheduled(fixedDelay = 5000)
    void nbPlacesDisponiblesParChambreAnneeEnCours();

    Reservation assignChambreToEtudiant(Long cin, TypeChambre typeChambre);
}
