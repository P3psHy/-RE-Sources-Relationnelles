package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.model.Activite;
import com.ajmservices.javabackend.service.ActiviteService;

@RestController
@RequestMapping("/api/activites")
public class ActiviteController {

    @Autowired
    private ActiviteService activiteService;

    @PostMapping
    public Activite createActivite(@RequestBody Activite activite) {
        return activiteService.createActivite(activite);
    }

    @GetMapping
    public Iterable<Activite> getAllActivites() {
        return activiteService.getAllActivites();
    }

    @GetMapping("/{id}")
    public Activite getActiviteById(@PathVariable Long id) {
        return activiteService.getActiviteById(id);
    }

    @PutMapping("/{id}")
    public Activite updateActivite(@PathVariable Long id, @RequestBody Activite activite) {
        return activiteService.updateActivite(id, activite);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        activiteService.deleteActivite(id);
    }
}