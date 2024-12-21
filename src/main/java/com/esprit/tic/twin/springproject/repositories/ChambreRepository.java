package com.esprit.tic.twin.springproject.repositories;

import com.esprit.tic.twin.springproject.entities.Chambre;
import com.esprit.tic.twin.springproject.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    //Keyword
    List<Chambre> findByTypeC(TypeChambre typeChambre);

    List<Chambre> findByBlocNomBlocAndTypeC(String nomBloc, TypeChambre type);
    List<Chambre> findByReservationsEstValide(Boolean status);
    List<Chambre> findByBlocNomBlocAndBlocCapaciteBlocGreaterThan(String nomBloc, long capacite);
    List<Chambre> findByBlocNomBloc(String nomBloc);
    long countChambreByTypeCAndBlocIdBloc(TypeChambre type, long idBloc);
    Chambre findByNumeroChambre(Long numChambre);
    List<Chambre> findByReservationsEstValideAndTypeC(boolean b, TypeChambre typeChambre);

    //JPQL

    @Query("SELECT e FROM Chambre e WHERE e.bloc.nomBloc=:nomBloc AND e.typeC=:type")
    List<Chambre> retrieveChambreDoubleByBloc(@Param("nomBloc") String nomBloc, @Param("type") TypeChambre type);

    @Query("SELECT e FROM Chambre e JOIN e.reservations f WHERE f.estValide=:status")
    List<Chambre> retrieveChambreByReservation(@Param("status")Boolean status);

    @Query("SELECT e FROM Chambre e WHERE e.bloc.nomBloc=:nomBloc AND e.bloc.capaciteBloc>:capacite")
    List<Chambre> retrieveChambreDoubleByBlocAndCapacite(@Param("nomBloc") String nomBloc, @Param("capacite") long capacite);

    List<Chambre> findAllByNumeroChambreIn(List<Long> numChambre);

    @Query("SELECT e FROM Chambre e WHERE e.typeC=:type AND e.bloc.idBloc=:idBloc")
    long retrieveCountByTypeAndBlocId(@Param("type") String type, @Param("idBloc") long idBloc);

    @Query("SELECT e FROM Chambre e JOIN e.reservations f WHERE f.estValide=:status AND FUNCTION('YEAR', f.anneeUniversitaire) = :year")
    List<Chambre> retrieveChambreByReservationAndYear(@Param("status") Boolean status, @Param("year") int year);

    @Query("SELECT e FROM Chambre e JOIN e.reservations f WHERE f.estValide=:status AND e.typeC=:type AND FUNCTION('YEAR', f.anneeUniversitaire) = :year")
    List<Chambre> retrieveChambreByTypeAndReservationAndYear(@Param("status") Boolean status, @Param("type") TypeChambre type, @Param("year") int year);

}
