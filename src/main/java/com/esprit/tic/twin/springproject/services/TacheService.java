package com.esprit.tic.twin.springproject.services;

import com.esprit.tic.twin.springproject.repositories.TacheRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TacheService implements ITacheService{
    TacheRepository tacheRepository;
}
