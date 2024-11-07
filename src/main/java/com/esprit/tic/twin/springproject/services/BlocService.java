package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Bloc;
import com.esprit.tic.twin.springproject.repositories.BlocRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@AllArgsConstructor
public class BlocService implements IBlocService{
    BlocRepository blocRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc f) {
        return blocRepository.save(f);
    }

    @Override
    public Bloc updateBloc(Bloc f) {
        return blocRepository.save(f);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public List<Bloc> findBlocsByUniversityName(String nom) {
        return blocRepository.findByFoyerUniversiteNomUniversite(nom);
    }

    @Override
    public List<Bloc> retrieveBlocByUniversity(String nom) {
        return blocRepository.retrieveBlocByUniversite(nom);
    }
}
