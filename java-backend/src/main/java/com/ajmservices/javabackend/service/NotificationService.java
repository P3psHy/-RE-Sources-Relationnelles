package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.Notification;
import com.ajmservices.javabackend.repository.NotificationRepository;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Iterable<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public Notification updateNotification(Long id, Notification notification) {
        notification.setIdNotification(id);
        return notificationRepository.save(notification);
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}