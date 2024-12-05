package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Etudiant;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant(Etudiant f);
    Etudiant updateEtudiant(Etudiant f);
    Etudiant retrieveEtudiant(Long idEtudiant);
    void removeEtudiant(Long idEtudiant);

    Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation);

    HashMap<String, Float> calculNouveauMontantInscriptionDesEtudiants();

    @Scheduled(cron = "0 0 9 31 */12 *")
    void updateNouveauMontantInscriptionDesEtudiants();
}
