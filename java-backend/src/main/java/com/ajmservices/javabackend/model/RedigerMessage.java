package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class RedigerMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "date")
    private DatetimeEntity date;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur_RedigerMessage")
    private Utilisateur utilisateurRedigerMessage;

    private String message;

    // Getters and setters
}

