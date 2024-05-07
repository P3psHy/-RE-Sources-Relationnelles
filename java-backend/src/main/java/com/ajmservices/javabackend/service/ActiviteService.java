package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.Activite;
import com.ajmservices.javabackend.repository.ActiviteRepository;

@Service
public class ActiviteService {

    @Autowired
    private ActiviteRepository activiteRepository;

    public Activite createActivite(Activite activite) {
        return activiteRepository.save(activite);
    }

    public Iterable<Activite> getAllActivites() {
        return activiteRepository.findAll();
    }

    public Activite getActiviteById(Long id) {
        return activiteRepository.findById(id).orElse(null);
    }

    public Activite updateActivite(Long id, Activite activite) {
        activite.setIdRessource(id);
        return activiteRepository.save(activite);
    }

    public void deleteActivite(Long id) {
        activiteRepository.deleteById(id);
    }
}