package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.Ressource;
import com.ajmservices.javabackend.repository.RessourceRepository;

@Service
public class RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;

    public Ressource createRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    public Iterable<Ressource> getAllRessources() {
        return ressourceRepository.findAll();
    }

    public Ressource getRessourceById(Long id) {
        return ressourceRepository.findById(id).orElse(null);
    }

    public Ressource updateRessource(Long id, Ressource ressource) {
        ressource.setIdRessource(id);
        return ressourceRepository.save(ressource);
    }

    public void deleteRessource(Long id) {
        ressourceRepository.deleteById(id);
    }
}