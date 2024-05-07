package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.model.EtatRessource;
import com.ajmservices.javabackend.service.EtatRessourceService;

@RestController
@RequestMapping("/api/etatsressource")
public class EtatRessourceController {

    @Autowired
    private EtatRessourceService etatRessourceService;

    @PostMapping
    public EtatRessource createEtatRessource(@RequestBody EtatRessource etatRessource) {
        return etatRessourceService.createEtatRessource(etatRessource);
    }

    @GetMapping
    public Iterable<EtatRessource> getAllEtatRessources() {
        return etatRessourceService.getAllEtatRessources();
    }

    @GetMapping("/{id}")
    public EtatRessource getEtatRessourceById(@PathVariable Long id) {
        return etatRessourceService.getEtatRessourceById(id);
    }

    @PutMapping("/{id}")
    public EtatRessource updateEtatRessource(@PathVariable Long id, @RequestBody EtatRessource etatRessource) {
        return etatRessourceService.updateEtatRessource(id, etatRessource);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        etatRessourceService.deleteEtatRessource(id);
    }
}