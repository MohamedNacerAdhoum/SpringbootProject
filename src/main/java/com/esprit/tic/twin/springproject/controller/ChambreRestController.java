package com.esprit.tic.twin.springproject.controller;

import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.services.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;

    // http://localhost:8090/projet/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listchambres = chambreService.retrieveAllChambres();
        if(listchambres.isEmpty()) {
            return null;
        }else return listchambres;
    }

    // http://localhost:8090/projet/chambre/retrieve-chambre/{idChambre}
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chambreId) {
        return chambreService.retrieveChambre(chambreId);
    }

    // http://localhost:8090/projet/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre e) {
        return chambreService.addChambre(e);
    }
}
