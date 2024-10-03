package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Universite;
import com.esprit.tic.twin.springproject.repositories.UniversiteRepository;

import java.util.List;

public class UniversiteService implements IUniversiteService{
    UniversiteRepository universiteRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite f) {
        return universiteRepository.save(f);
    }

    @Override
    public Universite updateUniversite(Universite f) {
        return universiteRepository.save(f);
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void removeUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
}