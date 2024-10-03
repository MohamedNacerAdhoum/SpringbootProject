package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite(Universite f);
    Universite updateUniversite(Universite f);
    Universite retrieveUniversite(Long idUniversite);
    void removeUniversite(Long idUniversite);
}
