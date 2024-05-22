package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.model.MessageUtilisateur;
import com.ajmservices.javabackend.service.MessageUtilisateurService;

@RestController
@RequestMapping("/api/messagesutilisateur")
public class MessageUtilisateurController {

    @Autowired
    private MessageUtilisateurService messageUtilisateurService;

    @PostMapping
    public MessageUtilisateur createMessageUtilisateur(@RequestBody MessageUtilisateur messageUtilisateur) {
        return messageUtilisateurService.createMessageUtilisateur(messageUtilisateur);
    }

    @GetMapping
    public Iterable<MessageUtilisateur> getAllMessageUtilisateurs() {
        return messageUtilisateurService.getAllMessageUtilisateurs();
    }

    @GetMapping("/{id}")
    public MessageUtilisateur getMessageUtilisateurById(@PathVariable Long id) {
        return messageUtilisateurService.getMessageUtilisateurById(id);
    }

    @PutMapping("/{id}")
    public MessageUtilisateur updateMessageUtilisateur(@PathVariable Long id, @RequestBody MessageUtilisateur messageUtilisateur) {
        return messageUtilisateurService.updateMessageUtilisateur(id, messageUtilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        messageUtilisateurService.deleteMessageUtilisateur(id);
    }
}