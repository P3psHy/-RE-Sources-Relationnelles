package com.ajmservices.javabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ajmservices.javabackend.model.MessageActivite;
import com.ajmservices.javabackend.service.MessageActiviteService;

@RestController
@RequestMapping("/api/messagesactivite")
public class MessageActiviteController {

    @Autowired
    private MessageActiviteService messageActiviteService;

    @PostMapping
    public MessageActivite createMessageActivite(@RequestBody MessageActivite messageActivite) {
        return messageActiviteService.createMessageActivite(messageActivite);
    }

    @GetMapping
    public Iterable<MessageActivite> getAllMessageActivites() {
        return messageActiviteService.getAllMessageActivites();
    }

    @GetMapping("/{id}")
    public MessageActivite getMessageActiviteById(@PathVariable Long id) {
        return messageActiviteService.getMessageActiviteById(id);
    }

    @PutMapping("/{id}")
    public MessageActivite updateMessageActivite(@PathVariable Long id, @RequestBody MessageActivite messageActivite) {
        return messageActiviteService.updateMessageActivite(id, messageActivite);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        messageActiviteService.deleteMessageActivite(id);
    }
}