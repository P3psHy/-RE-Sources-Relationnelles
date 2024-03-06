package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.model.TypeRelation;
import com.ajmservices.javabackend.service.TypeRelationService;

@RestController
@RequestMapping("/api/typesrelation")
public class TypeRelationController {

    @Autowired
    private TypeRelationService typeRelationService;

    @PostMapping
    public TypeRelation createTypeRelation(@RequestBody TypeRelation typeRelation) {
        return typeRelationService.createTypeRelation(typeRelation);
    }

    @GetMapping
    public Iterable<TypeRelation> getAllTypeRelations() {
        return typeRelationService.getAllTypeRelations();
    }

    @GetMapping("/{id}")
    public TypeRelation getTypeRelationById(@PathVariable Long id) {
        return typeRelationService.getTypeRelationById(id);
    }

    @PutMapping("/{id}")
    public TypeRelation updateTypeRelation(@PathVariable Long id, @RequestBody TypeRelation typeRelation) {
        return typeRelationService.updateTypeRelation(id, typeRelation);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        typeRelationService.deleteTypeRelation(id);
    }
}