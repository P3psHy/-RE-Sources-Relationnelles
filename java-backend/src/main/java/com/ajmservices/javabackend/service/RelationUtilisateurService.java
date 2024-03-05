package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.RelationUtilisateur;
import com.ajmservices.javabackend.repository.RelationUtilisateurRepository;

@Service
public class RelationUtilisateurService {

    @Autowired
    private RelationUtilisateurRepository relationUtilisateurRepository;

    public RelationUtilisateur createRelationUtilisateur(RelationUtilisateur relationUtilisateur) {
        return relationUtilisateurRepository.save(relationUtilisateur);
    }

    public Iterable<RelationUtilisateur> getAllRelationUtilisateurs() {
        return relationUtilisateurRepository.findAll();
    }

    public RelationUtilisateur getRelationUtilisateurById(Long id) {
        return relationUtilisateurRepository.findById(id).orElse(null);
    }

    public RelationUtilisateur updateRelationUtilisateur(Long id, RelationUtilisateur relationUtilisateur) {
        relationUtilisateur.setIdRelationUtilisateur(id);
        return relationUtilisateurRepository.save(relationUtilisateur);
    }

    public void deleteRelationUtilisateur(Long id) {
        relationUtilisateurRepository.deleteById(id);
    }
}