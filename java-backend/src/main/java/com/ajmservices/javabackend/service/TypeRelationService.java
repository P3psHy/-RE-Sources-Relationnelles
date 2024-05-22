package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.TypeRelation;
import com.ajmservices.javabackend.repository.TypeRelationRepository;

@Service
public class TypeRelationService {

    @Autowired
    private TypeRelationRepository typeRelationRepository;

    public TypeRelation createTypeRelation(TypeRelation typeRelation) {
        return typeRelationRepository.save(typeRelation);
    }

    public Iterable<TypeRelation> getAllTypeRelations() {
        return typeRelationRepository.findAll();
    }

    public TypeRelation getTypeRelationById(Long id) {
        return typeRelationRepository.findById(id).orElse(null);
    }

    public TypeRelation updateTypeRelation(Long id, TypeRelation typeRelation) {
        typeRelation.setIdTypeRelation(id);
        return typeRelationRepository.save(typeRelation);
    }

    public void deleteTypeRelation(Long id) {
        typeRelationRepository.deleteById(id);
    }
}