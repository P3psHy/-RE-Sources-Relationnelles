package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.Fichier;
import com.ajmservices.javabackend.repository.FichierRepository;

@Service
public class FichierService {

    @Autowired
    private FichierRepository fichierRepository;

    public Fichier createFichier(Fichier fichier) {
        return fichierRepository.save(fichier);
    }

    public Iterable<Fichier> getAllFichiers() {
        return fichierRepository.findAll();
    }

    public Fichier getFichierById(Long id) {
        return fichierRepository.findById(id).orElse(null);
    }

    public Fichier updateFichier(Long id, Fichier fichier) {
        fichier.setIdFichier(id);
        return fichierRepository.save(fichier);
    }

    public void deleteFichier(Long id) {
        fichierRepository.deleteById(id);
    }
}