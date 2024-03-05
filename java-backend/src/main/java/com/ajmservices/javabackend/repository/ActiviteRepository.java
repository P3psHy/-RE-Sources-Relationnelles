package com.ajmservices.javabackend.repository;

import org.springframework.data.repository.CrudRepository;
import com.ajmservices.javabackend.model.Activite;


public interface ActiviteRepository extends CrudRepository<Activite, Long> {
    
}
