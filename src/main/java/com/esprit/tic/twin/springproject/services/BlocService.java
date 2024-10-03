package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Bloc;
import com.esprit.tic.twin.springproject.repositories.BlocRepository;

import java.util.List;

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
}
