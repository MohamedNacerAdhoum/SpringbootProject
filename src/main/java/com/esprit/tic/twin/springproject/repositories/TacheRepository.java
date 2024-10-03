package com.esprit.tic.twin.springproject.repositories;

import com.esprit.tic.twin.springproject.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}
