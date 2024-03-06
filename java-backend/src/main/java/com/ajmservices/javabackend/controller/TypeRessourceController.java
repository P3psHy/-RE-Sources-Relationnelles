package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.model.TypeRessource;
import com.ajmservices.javabackend.service.TypeRessourceService;

@RestController
@RequestMapping("/api/typesressource")
public class TypeRessourceController {

    @Autowired
    private TypeRessourceService typeRessourceService;

    @PostMapping
    public TypeRessource createTypeRessource(@RequestBody TypeRessource typeRessource) {
        return typeRessourceService.createTypeRessource(typeRessource);
    }

    @GetMapping
    public Iterable<TypeRessource> getAllTypeRessources() {
        return typeRessourceService.getAllTypeRessources();
    }

    @GetMapping("/{id}")
    public TypeRessource getTypeRessourceById(@PathVariable Long id) {
        return typeRessourceService.getTypeRessourceById(id);
    }

    @PutMapping("/{id}")
    public TypeRessource updateTypeRessource(@PathVariable Long id, @RequestBody TypeRessource typeRessource) {
        return typeRessourceService.updateTypeRessource(id, typeRessource);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        typeRessourceService.deleteTypeRessource(id);
    }
}