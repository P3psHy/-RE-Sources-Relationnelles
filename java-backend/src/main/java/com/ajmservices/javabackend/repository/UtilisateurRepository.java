package com.ajmservices.javabackend.repository;

import org.springframework.data.repository.CrudRepository;
import com.ajmservices.javabackend.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>{
    
}
