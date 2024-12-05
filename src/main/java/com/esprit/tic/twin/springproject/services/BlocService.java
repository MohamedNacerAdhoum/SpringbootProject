package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Bloc;
import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.repositories.BlocRepository;
import com.esprit.tic.twin.springproject.repositories.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class BlocService implements IBlocService{
    ChambreRepository chambreRepository;
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

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        List<Chambre> chambres = chambreRepository.findAllByNumeroChambreIn(numChambre);
        chambres.forEach(chambre -> chambre.setBloc(bloc));
        chambreRepository.saveAll(chambres);
        return blocRepository.findByNomBloc(nomBloc);
    }

    //@Scheduled(fixedDelay = 5000)
    @Override
    public void listChambresParBloc(){
        List<Bloc> blocList = blocRepository.findAll();
        blocList.forEach(bloc -> {
            log.info("Bloc: {} ayant la capacité de: {}", bloc.getNomBloc(), bloc.getCapaciteBloc());
            Set<Chambre> chambres = bloc.getChambres();
            if (!chambres.isEmpty()) {
                log.info("Liste des chambres de bloc {}:",bloc.getNomBloc());
                chambres.forEach(chambre -> log.info("Chambre numéro {} de type {}", chambre.getNumeroChambre(), chambre.getTypeC()));
            }
            else  log.info("Bloc {} vide",bloc.getNomBloc());
        });
    }
}
