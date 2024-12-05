package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Bloc;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveAllBlocs();
    Bloc addBloc(Bloc f);
    Bloc updateBloc(Bloc f);
    Bloc retrieveBloc(Long idBloc);
    void removeBloc(Long idBloc);

    // JPQL Keyword

    List<Bloc> findBlocsByUniversityName(String nom);
    List<Bloc> retrieveBlocByUniversity(String nom);

    Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) ;

    @Scheduled(fixedDelay = 5000)
    void listChambresParBloc();
}
