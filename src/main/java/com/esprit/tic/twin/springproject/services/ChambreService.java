package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.entities.TypeChambre;
import com.esprit.tic.twin.springproject.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreService implements IChambreService{
    ChambreRepository chambreRepository;
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
}
