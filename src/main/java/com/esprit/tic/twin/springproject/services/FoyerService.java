package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Foyer;
import com.esprit.tic.twin.springproject.repositories.BlocRepository;
import com.esprit.tic.twin.springproject.repositories.FoyerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class FoyerService implements IFoyerService {
    BlocRepository blocrepository;
    FoyerRepository foyerRepository;
    @Override
    public Foyer addFoyerWithBloc(Foyer f){
        Foyer foyer = foyerRepository.save(f);
        foyer.getBlocs().forEach(bloc -> {
            bloc.setFoyer(foyer);
            blocrepository.save(bloc);
        });
        return foyer;
    }

}
