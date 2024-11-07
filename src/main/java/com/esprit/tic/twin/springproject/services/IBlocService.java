package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();
    Bloc addBloc(Bloc f);
    Bloc updateBloc(Bloc f);
    Bloc retrieveBloc(Long idBloc);
    void removeBloc(Long idBloc);

    // JPQL keyword
    List<Bloc> findBlocsByUniversityName(String nom);
    List<Bloc> retrieveBlocByUniversity(String nom);
}
