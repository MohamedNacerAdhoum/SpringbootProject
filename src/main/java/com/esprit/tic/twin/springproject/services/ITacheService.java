package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Tache;

import java.util.List;

public interface ITacheService {
    List<Tache> addTasksAndAffectToEtudiant(List<Tache> tasks, String nomEt, String prenomEt) ;
}
