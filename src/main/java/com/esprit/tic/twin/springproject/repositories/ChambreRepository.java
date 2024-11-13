package com.esprit.tic.twin.springproject.repositories;

import com.esprit.tic.twin.springproject.entities.Bloc;
import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    //Keyword

    List<Chambre> findByBlocNomBlocAndTypeC(String nomBloc, TypeChambre type);
    List<Chambre> findByReservationsEstValide(Boolean status);
    List<Chambre> findByBlocNomBlocAndBlocCapaciteBlocGreaterThan(String nomBloc, long capacite);
    //JPQL

    @Query("SELECT e FROM Chambre e WHERE e.bloc.nomBloc=:nomBloc AND e.typeC=:type")
    List<Chambre> retrieveChambreDoubleByBloc(@Param("nomBloc") String nomBloc, @Param("type") TypeChambre type);
    @Query("SELECT e FROM Chambre e JOIN e.reservations f WHERE f.estValide=:status")
    List<Chambre> retrieveChambreByReservation(@Param("status")Boolean status);
    @Query("SELECT e FROM Chambre e WHERE e.bloc.nomBloc=:nomBloc AND e.bloc.capaciteBloc>:capacite")
    List<Chambre> retrieveChambreDoubleByBlocAndCapacite(@Param("nomBloc") String nomBloc, @Param("capacite") long capacite);
}
