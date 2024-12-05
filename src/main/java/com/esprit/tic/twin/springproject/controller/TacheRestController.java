package com.esprit.tic.twin.springproject.controller;

import com.esprit.tic.twin.springproject.entities.Tache;
import com.esprit.tic.twin.springproject.services.ITacheService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class TacheRestController {
    ITacheService tacheService;
    // http://localhost:8090/projet/tache/add-taches
    @PutMapping("/add-taches/")
    public List<Tache> affectReservation(@RequestBody List<Tache> taches, @RequestParam String nom, @RequestParam String prenom) {
        return tacheService.addTasksAndAffectToEtudiant(taches,nom,prenom);
    }

}
