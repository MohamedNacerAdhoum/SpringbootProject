package com.esprit.tic.twin.springproject.controller;

import com.esprit.tic.twin.springproject.services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UniversiteRestController {
    IUniversiteService universiteService;
}
