package com.esprit.tic.twin.springproject.repositories;

import com.esprit.tic.twin.springproject.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
