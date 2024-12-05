package com.esprit.tic.twin.springproject.controller;

import com.esprit.tic.twin.springproject.entities.Foyer;
import com.esprit.tic.twin.springproject.services.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FoyerRestController {
    IFoyerService foyerService;
    // http://localhost:8090/projet/foyer/affecter-foyer
    @PutMapping("/affecter-foyer")
    public Foyer affectFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyerWithBloc(foyer);
    }
}
