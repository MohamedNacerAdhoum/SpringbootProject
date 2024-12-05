package com.esprit.tic.twin.springproject.repositories;

import com.esprit.tic.twin.springproject.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    List<Foyer> findByUniversiteNomUniversite(String nom);
    List<Foyer> findByBlocsNomBloc(String nom);
    List<Foyer> findByUniversiteNomUniversiteAndBlocsNomBloc(String nomU, String nomB);

    Foyer findByNomFoyer(String nomFoyer);
    @Query("SELECT f FROM Foyer f WHERE f.nomFoyer = :nomFoyer")
    Foyer findByNomFoyerJPQL(@Param("nomFoyer") String nomFoyer);

}
