package com.esprit.tic.twin.springproject.controller;

import com.esprit.tic.twin.springproject.entities.Etudiant;
import com.esprit.tic.twin.springproject.services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantRestController {
    IEtudiantService etudiantService;
    // http://localhost:8090/projet/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getetudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        if(listEtudiants.isEmpty()) {
            return null;
        }else return listEtudiants;
    }
    // http://localhost:8090/projet/etudiant/affecter-reservation
    @PutMapping("/affecter-reservation/{idReservation}")
    public Etudiant affectReservation(@PathVariable("idReservation") String e, @RequestParam String nom, @RequestParam String prenom) {
        return etudiantService.affecterEtudiantAReservation(e,nom,prenom);
    }
    // http://localhost:8090/projet/etudiant/calcul-montant-inscription
    @GetMapping("/calcul-montant-inscription/")
    public HashMap<String, Float> affectReservation() {
        return etudiantService.calculNouveauMontantInscriptionDesEtudiants();
    }
}
