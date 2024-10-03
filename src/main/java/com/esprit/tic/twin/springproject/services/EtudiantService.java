package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Etudiant;
import com.esprit.tic.twin.springproject.repositories.EtudiantRepository;

import java.util.List;

public class EtudiantService implements IEtudiantService{
    EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant f) {
        return etudiantRepository.save(f);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant f) {
        return etudiantRepository.save(f);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
