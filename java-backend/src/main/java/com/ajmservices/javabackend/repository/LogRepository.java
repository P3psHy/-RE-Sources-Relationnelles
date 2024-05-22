package com.ajmservices.javabackend.repository;

import org.springframework.data.repository.CrudRepository;
import com.ajmservices.javabackend.model.Log;

public interface LogRepository extends CrudRepository<Log, Long> {

    
}
