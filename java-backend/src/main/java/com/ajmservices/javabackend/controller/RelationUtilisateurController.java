package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.model.RelationUtilisateur;
import com.ajmservices.javabackend.service.RelationUtilisateurService;

@RestController
@RequestMapping("/api/relationsutilisateur")
public class RelationUtilisateurController {

    @Autowired
    private RelationUtilisateurService relationUtilisateurService;

    @PostMapping
    public RelationUtilisateur createRelationUtilisateur(@RequestBody RelationUtilisateur relationUtilisateur) {
        return relationUtilisateurService.createRelationUtilisateur(relationUtilisateur);
    }

    @GetMapping
    public Iterable<RelationUtilisateur> getAllRelationUtilisateurs() {
        return relationUtilisateurService.getAllRelationUtilisateurs();
    }

    @GetMapping("/{id}")
    public RelationUtilisateur getRelationUtilisateurById(@PathVariable Long id) {
        return relationUtilisateurService.getRelationUtilisateurById(id);
    }

    @PutMapping("/{id}")
    public RelationUtilisateur updateRelationUtilisateur(@PathVariable Long id, @RequestBody RelationUtilisateur relationUtilisateur) {
        return relationUtilisateurService.updateRelationUtilisateur(id, relationUtilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        relationUtilisateurService.deleteRelationUtilisateur(id);
    }
}