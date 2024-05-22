package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.TypeRessource;
import com.ajmservices.javabackend.repository.TypeRessourceRepository;

@Service
public class TypeRessourceService {

    @Autowired
    private TypeRessourceRepository typeRessourceRepository;

    public TypeRessource createTypeRessource(TypeRessource typeRessource) {
        return typeRessourceRepository.save(typeRessource);
    }

    public Iterable<TypeRessource> getAllTypeRessources() {
        return typeRessourceRepository.findAll();
    }

    public TypeRessource getTypeRessourceById(Long id) {
        return typeRessourceRepository.findById(id).orElse(null);
    }

    public TypeRessource updateTypeRessource(Long id, TypeRessource typeRessource) {
        typeRessource.setIdTypeRessource(id);
        return typeRessourceRepository.save(typeRessource);
    }

    public void deleteTypeRessource(Long id) {
        typeRessourceRepository.deleteById(id);
    }
}