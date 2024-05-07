package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.EtatRessource;
import com.ajmservices.javabackend.repository.EtatRessourceRepository;

@Service
public class EtatRessourceService {

    @Autowired
    private EtatRessourceRepository etatRessourceRepository;

    public EtatRessource createEtatRessource(EtatRessource etatRessource) {
        return etatRessourceRepository.save(etatRessource);
    }

    public Iterable<EtatRessource> getAllEtatRessources() {
        return etatRessourceRepository.findAll();
    }

    public EtatRessource getEtatRessourceById(Long id) {
        return etatRessourceRepository.findById(id).orElse(null);
    }

    public EtatRessource updateEtatRessource(Long id, EtatRessource etatRessource) {
        etatRessource.setIdEtatRessource(id);
        return etatRessourceRepository.save(etatRessource);
    }

    public void deleteEtatRessource(Long id) {
        etatRessourceRepository.deleteById(id);
    }
}