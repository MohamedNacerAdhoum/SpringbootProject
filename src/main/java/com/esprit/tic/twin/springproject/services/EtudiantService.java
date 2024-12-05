package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.entities.Etudiant;
import com.esprit.tic.twin.springproject.entities.Reservation;
import com.esprit.tic.twin.springproject.repositories.EtudiantRepository;
import com.esprit.tic.twin.springproject.repositories.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{
    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant f) {
        return etudiantRepository.save(f);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant f) {
        return etudiantRepository.save(f);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant affecterEtudiantAReservation(String idReservation, String nomEt, String prenomEt) {
        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + idReservation));
        Etudiant etudiant = etudiantRepository.findByNomEtAndPrenomEt(nomEt,prenomEt);
        Set<Reservation> reservations = new HashSet<>();
        if(etudiant.getReservations() != null){
            reservations=etudiant.getReservations();
        }
        reservations.add(reservation);
        etudiant.setReservations(reservations);
        etudiantRepository.save(etudiant);
        return etudiant;
    }

    @Override
    public HashMap<String, Float> calculNouveauMontantInscriptionDesEtudiants() {
        HashMap<String, Float> resultat = new HashMap<>();
        List<Etudiant> etudiants = etudiantRepository.findAll();
        for(Etudiant etudiant: etudiants){
            float montantTaches = etudiant.getTaches()
                    .stream()
                    .filter(tache -> tache.getDateTache().getYear() == LocalDate.now().getYear())
                    .map(tache -> tache.getTarifHoraire() * tache.getDuree())
                    .reduce(0F, Float::sum);
            float nouveauMontantInscription = Math.max(etudiant.getMontantInscription() - montantTaches, 0);
            String nomComplet = etudiant.getNomEt() + " " + etudiant.getPrenomEt();
            resultat.put(nomComplet, nouveauMontantInscription);
        }
        return resultat;
    }

    @Scheduled(cron = "0 0 9 31 */12 *")
    @Override
    public void updateNouveauMontantInscriptionDesEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        for(Etudiant etudiant: etudiants){
            float montantTaches = etudiant.getTaches()
                    .stream()
                    .filter(tache -> tache.getDateTache().getYear() == LocalDate.now().getYear())
                    .map(tache -> tache.getTarifHoraire() * tache.getDuree())
                    .reduce(0F, Float::sum);
            float nouveauMontantInscription = Math.max(etudiant.getMontantInscription() - montantTaches, 0);
            etudiant.setMontantInscription(nouveauMontantInscription);
            etudiantRepository.save(etudiant);
            log.info("Nouveau Montant Inscription mettre a jour avec success");
        }
    }

}
