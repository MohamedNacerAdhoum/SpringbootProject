package com.esprit.tic.twin.springproject.controller;

import com.esprit.tic.twin.springproject.entities.Bloc;
import com.esprit.tic.twin.springproject.entities.Universite;
import com.esprit.tic.twin.springproject.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    // http://localhost:8090/projet/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        if(listBlocs.isEmpty()) {
            return null;
        }else return listBlocs;
    }

    // http://localhost:8090/projet/bloc/retrieve-bloc/8
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrievebloc(@PathVariable("bloc-id") Long blocId) {
        return blocService.retrieveBloc(blocId);
    }

    // http://localhost:8090/projet/bloc/add-bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc e) {
        return blocService.addBloc(e);
    }

    // http://localhost:8090/projet/bloc/remove-bloc/{bloc-id}
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }

    // http://localhost:8090/projet/bloc/update-bloc
    @PutMapping("/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc e) {
        return blocService.updateBloc(e);
    }

    // http://localhost:8090/projet/bloc/find-bloc-keyword
    @GetMapping("/find-bloc-keyword/{universityName}")
    public List<Bloc> findBlocsByUniversityName(@PathVariable("universityName") String universityName) {
        return blocService.findBlocsByUniversityName(universityName);
    }

    // http://localhost:8090/projet/bloc/find-bloc-jpql
    @GetMapping("/find-bloc-jpql/{universityName}")
    public List<Bloc> retrieveBlocByUniversity(@PathVariable("universityName") String universityName) {
        return blocService.retrieveBlocByUniversity(universityName);
    }

    // http://localhost:8090/projet/bloc/affecter-bloc
    @PutMapping("/affecter-bloc/{nomBloc}")
    public Bloc affectBloc(@PathVariable("nomBloc") String e, @RequestBody List<Long> u) {
        return blocService.affecterChambresABloc(u,e);
    }
}
