package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.DTO.RessourceUtilisateurDTO;
import com.ajmservices.javabackend.model.Ressource;
import com.ajmservices.javabackend.service.RessourceService;



@RestController
@RequestMapping("/api/ressources")
public class RessourceController {

    @Autowired
    private RessourceService ressourceService;

    @PostMapping
    public Ressource createRessource(@RequestBody Ressource ressource) {
        return ressourceService.createRessource(ressource);
    }

    @GetMapping
    public Iterable<Ressource> getAllRessources() {
        return ressourceService.getAllRessources();
    }

    @GetMapping("/{id}")
    public Ressource getRessourceById(@PathVariable Long id) {
        return ressourceService.getRessourceById(id);
    }

    @PutMapping("/{id}")
    public Ressource updateRessource(@PathVariable Long id, @RequestBody Ressource ressource) {
        return ressourceService.updateRessource(id, ressource);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        ressourceService.deleteRessource(id);
    }

    @GetMapping("/ressourceUser/{ressourceId}")
    public RessourceUtilisateurDTO getRessourceUtilisateur(@PathVariable Long ressourceId) {
        return ressourceService.getRessourceUtilisateurByRessourceId(ressourceId);
    }

    
}