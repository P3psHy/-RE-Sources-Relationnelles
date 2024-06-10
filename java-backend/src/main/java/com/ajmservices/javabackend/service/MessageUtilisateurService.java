package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.MessageUtilisateur;
import com.ajmservices.javabackend.repository.MessageUtilisateurRepository;

@Service
public class MessageUtilisateurService {

    @Autowired
    private MessageUtilisateurRepository messageUtilisateurRepository;

    public MessageUtilisateur createMessageUtilisateur(MessageUtilisateur messageUtilisateur) {
        return messageUtilisateurRepository.save(messageUtilisateur);
    }

    public Iterable<MessageUtilisateur> getAllMessageUtilisateurs() {
        return messageUtilisateurRepository.findAll();
    }

    public MessageUtilisateur getMessageUtilisateurById(Long id) {
        return messageUtilisateurRepository.findById(id).orElse(null);
    }

    public MessageUtilisateur updateMessageUtilisateur(Long id, MessageUtilisateur messageUtilisateur) {
        messageUtilisateur.setIdMessageUtilisateur(id);
        return messageUtilisateurRepository.save(messageUtilisateur);
    }

    public void deleteMessageUtilisateur(Long id) {
        messageUtilisateurRepository.deleteById(id);
    }
}