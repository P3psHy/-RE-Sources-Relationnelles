package com.ajmservices.javabackend.repository;

import org.springframework.data.repository.CrudRepository;
import com.ajmservices.javabackend.model.MessageUtilisateur;

public interface MessageUtilisateurRepository extends CrudRepository<MessageUtilisateur, Integer> {
    
}
