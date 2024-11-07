package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre f);
    Chambre updateChambre(Chambre f);
    Chambre retrieveChambre(Long idChambre);
    void removeChambre(Long idChambre);
}
