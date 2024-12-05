package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Etudiant;
import com.esprit.tic.twin.springproject.entities.Tache;
import com.esprit.tic.twin.springproject.repositories.EtudiantRepository;
import com.esprit.tic.twin.springproject.repositories.TacheRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class TacheService implements ITacheService{
    EtudiantRepository etudiantRepository;
    TacheRepository tacheRepository;

    @Override
    public List<Tache> addTasksAndAffectToEtudiant(List<Tache> taches, String nomEt, String prenomEt) {
        tacheRepository.saveAll(taches);
        Etudiant etudiant = etudiantRepository.findByNomEtAndPrenomEt(nomEt, prenomEt);
        Set<Tache> tachesList = new HashSet<>();
        if(etudiant.getTaches()!=null){
            tachesList=etudiant.getTaches();
        }
        tachesList.addAll(taches);
        for (Tache tache : tachesList) {
            tache.setEtudiant(etudiant);
            tacheRepository.save(tache);
        }
        return taches;
    }
}
