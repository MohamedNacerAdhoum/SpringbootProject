package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant(Etudiant f);
    Etudiant updateEtudiant(Etudiant f);
    Etudiant retrieveEtudiant(Long idEtudiant);
    void removeEtudiant(Long idEtudiant);
}
