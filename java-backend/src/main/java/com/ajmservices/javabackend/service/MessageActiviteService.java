package com.ajmservices.javabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmservices.javabackend.model.MessageActivite;
import com.ajmservices.javabackend.repository.MessageActiviteRepository;

@Service
public class MessageActiviteService {

    @Autowired
    private MessageActiviteRepository messageActiviteRepository;

    public MessageActivite createMessageActivite(MessageActivite messageActivite) {
        return messageActiviteRepository.save(messageActivite);
    }

    public Iterable<MessageActivite> getAllMessageActivites() {
        return messageActiviteRepository.findAll();
    }

    public MessageActivite getMessageActiviteById(Long id) {
        return messageActiviteRepository.findById(id).orElse(null);
    }

    public MessageActivite updateMessageActivite(Long id, MessageActivite messageActivite) {
        messageActivite.setIdMessageActivite(id);
        return messageActiviteRepository.save(messageActivite);
    }

    public void deleteMessageActivite(Long id) {
        messageActiviteRepository.deleteById(id);
    }
}