package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Foyer;
import com.esprit.tic.twin.springproject.entities.Universite;
import com.esprit.tic.twin.springproject.repositories.FoyerRepository;
import com.esprit.tic.twin.springproject.repositories.UniversiteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{
    private final FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;
    @Override
    public Universite affecterFoyerAUniversite(long idUniversite, String nomFoyer){
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + idUniversite));
        Foyer foyer = foyerRepository.findByNomFoyerJPQL(nomFoyer);
        universite.setFoyer(foyer);
        universiteRepository.save(universite);
        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + idUniversite));
        universite.setFoyer(null);
        universiteRepository.save(universite);
        return universite;

    }
}