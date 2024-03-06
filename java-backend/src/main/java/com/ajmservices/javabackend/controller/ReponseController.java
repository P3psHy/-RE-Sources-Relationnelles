package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.model.Reponse;
import com.ajmservices.javabackend.service.ReponseService;

@RestController
@RequestMapping("/api/reponses")
public class ReponseController {

    @Autowired
    private ReponseService reponseService;

    @PostMapping
    public Reponse createReponse(@RequestBody Reponse reponse) {
        return reponseService.createReponse(reponse);
    }

    @GetMapping
    public Iterable<Reponse> getAllReponses() {
        return reponseService.getAllReponses();
    }

    @GetMapping("/{id}")
    public Reponse getReponseById(@PathVariable Long id) {
        return reponseService.getReponseById(id);
    }

    @PutMapping("/{id}")
    public Reponse updateReponse(@PathVariable Long id, @RequestBody Reponse reponse) {
        return reponseService.updateReponse(id, reponse);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        reponseService.deleteReponse(id);
    }
}