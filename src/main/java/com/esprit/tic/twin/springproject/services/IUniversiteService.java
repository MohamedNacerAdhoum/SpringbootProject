package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Universite;
import org.springframework.stereotype.Service;

@Service
public interface IUniversiteService {
    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite (long idUniversite) ;

}
