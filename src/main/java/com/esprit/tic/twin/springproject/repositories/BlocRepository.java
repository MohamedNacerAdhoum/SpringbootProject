package com.esprit.tic.twin.springproject.repositories;

import com.esprit.tic.twin.springproject.entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlocRepository extends JpaRepository <Bloc, Long> {
}
