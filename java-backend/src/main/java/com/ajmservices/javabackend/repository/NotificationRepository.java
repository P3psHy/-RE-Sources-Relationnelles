package com.ajmservices.javabackend.repository;

import org.springframework.data.repository.CrudRepository;
import com.ajmservices.javabackend.model.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {
    
}
