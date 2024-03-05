package com.ajmservices.javabackend.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Activite extends Ressource {

    @OneToMany(mappedBy = "activite")
    private Set<MessageActivite> messagesActivite = new HashSet<>();

    // Constructors
    public Activite() {
        super();
    }

    // public Activite(String nom) {
    //     super(nom);
    // }

    public Set<MessageActivite> getMessagesActivite() {
        return messagesActivite;
    }

    public void setMessagesActivite(Set<MessageActivite> messagesActivite) {
        this.messagesActivite = messagesActivite;
    }

}
