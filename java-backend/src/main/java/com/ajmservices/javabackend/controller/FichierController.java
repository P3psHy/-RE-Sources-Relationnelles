package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.model.Fichier;
import com.ajmservices.javabackend.service.FichierService;

@RestController
@RequestMapping("/api/fichiers")
public class FichierController {

    @Autowired
    private FichierService fichierService;

    @PostMapping
    public Fichier createFichier(@RequestBody Fichier fichier) {
        return fichierService.createFichier(fichier);
    }

    @GetMapping
    public Iterable<Fichier> getAllFichiers() {
        return fichierService.getAllFichiers();
    }

    @GetMapping("/{id}")
    public Fichier getFichierById(@PathVariable Long id) {
        return fichierService.getFichierById(id);
    }

    @PutMapping("/{id}")
    public Fichier updateFichier(@PathVariable Long id, @RequestBody Fichier fichier) {
        return fichierService.updateFichier(id, fichier);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        fichierService.deleteFichier(id);
    }
}