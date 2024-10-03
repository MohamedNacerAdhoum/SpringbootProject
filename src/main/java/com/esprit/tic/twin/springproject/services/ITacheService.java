package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Tache;

import java.util.List;

public interface ITacheService {
    List<Tache> retrieveAllTaches();
    Tache addTache(Tache f);
    Tache updateTache(Tache f);
    Tache retrieveTache(Long idTache);
    void removeTache(Long idTache);
}
