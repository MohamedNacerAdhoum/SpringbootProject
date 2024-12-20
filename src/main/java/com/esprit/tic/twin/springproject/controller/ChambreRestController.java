package com.esprit.tic.twin.springproject.controller;

import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.entities.Reservation;
import com.esprit.tic.twin.springproject.entities.TypeChambre;
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

    // http://localhost:8090/projet/chambre/remove-chambre
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chambreId) {
        chambreService.removeChambre(chambreId);
    }

    // http://localhost:8090/projet/chambre/update-chambre
    @PutMapping("/update-chambre")
    public Chambre updatechambre(@RequestBody Chambre e) {
        return chambreService.updateChambre(e);
    }

    // http://localhost:8090/projet/chambre/find-chambre-keyword
    @GetMapping("/find-chambre-keyword")
    public List<Chambre> findChambresByBlocAndTypeKeyword(@RequestParam String blocName, @RequestParam String type) {
        return chambreService.findChambreByNomBlocAndTypeCKeyword(blocName, type);
    }

    // http://localhost:8090/projet/chambre/find-chambre-jpql
    @GetMapping("/find-chambre-jpql")
    public List<Chambre> retrieveChambreByBlocAndTypeJPQL(@RequestParam String blocName, @RequestParam String type) {
        return chambreService.findChambreByNomBlocAndTypeCJPQL(blocName, type);
    }

    // http://localhost:8090/projet/chambre/find-chambre-keyword2
    @GetMapping("/find-reservation-keyword/{status}")
    public List<Chambre> retrieveChambreByReservationStatusKeyword(@PathVariable("status") String status) {
        return chambreService.findChambreByReservationStatusKeyword(status);
    }

    // http://localhost:8090/projet/chambre/find-chambre-jpql2
    @GetMapping("/find-reservation-jpql/{status}")
    public List<Chambre> retrieveChambreByReservationStatusJPQL(@PathVariable("status") String status) {
        return chambreService.findChambreByReservationStatusJPQL(status);
    }

    // http://localhost:8090/projet/chambre/find-bloc-keyword
    @GetMapping("/find-bloc-keyword")
    public List<Chambre> retrieveChambreByBlocNomBlocAndBlocCapaciteBlocGreaterThanKeyword(@RequestParam String blocName, @RequestParam long capacite) {
        return chambreService.findChambreByBlocNomBlocAndBlocCapaciteBlocGreaterThanKeyword(blocName, capacite);
    }

    // http://localhost:8090/projet/chambre/find-bloc-jpql
    @GetMapping("/find-bloc-jpql")
    public List<Chambre> retrieveChambreByBlocNomBlocAndBlocCapaciteBlocGreaterThanJPQL(@RequestParam String blocName, @RequestParam long capacite) {
        return chambreService.findChambreByBlocNomBlocAndBlocCapaciteBlocGreaterThanJPQL(blocName, capacite);
    }

    // http://localhost:8090/projet/chambre/find-bloc
    @GetMapping("/find-chambres-bloc")
    public List<Chambre> retrieveChambreByNomBloc(@RequestParam String blocName) {
        return chambreService.getChambresParNomBloc(blocName);
    }

    // http://localhost:8090/projet/chambre/find-bloc
    @GetMapping("/find-chambres-nb")
    public long countChambreByTypeAndIdBloc(@RequestParam TypeChambre typeCh, @RequestParam long idBloc) {
        return chambreService.nbChambreParTypeEtBloc(typeCh,idBloc);
    }

    @PostMapping("/affecter-chambre")
    public Reservation affectChambre(@RequestParam Long cin,@RequestParam TypeChambre typeChambre) {
        return chambreService.assignChambreToEtudiant(cin,typeChambre);
    }

}
