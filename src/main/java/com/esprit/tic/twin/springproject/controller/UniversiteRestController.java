package com.esprit.tic.twin.springproject.controller;

import com.esprit.tic.twin.springproject.entities.Universite;
import com.esprit.tic.twin.springproject.services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UniversiteRestController {
    IUniversiteService universiteService;
    // http://localhost:8090/projet/universite/affecter-universite
    @PutMapping("/affecter-universite/{idUniversite}")
    public Universite affectUniversite(@PathVariable("idUniversite") long e, @RequestBody String u) {
        return universiteService.affecterFoyerAUniversite(e,u);
    }

    // http://localhost:8090/projet/universite/desaffecter-universite
    @PutMapping("/desaffecter-universite/{idUniversite}")
    public Universite desaffectUniversite(@PathVariable("idUniversite") long e) {
        return universiteService.desaffecterFoyerAUniversite(e);
    }
}
