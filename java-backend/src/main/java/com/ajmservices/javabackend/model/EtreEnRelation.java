package com.ajmservices.javabackend.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;


public class EtreEnRelation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Utilisateur utilisateur1; //Ce sera l'utilisateur principale qui a été ajouté

    @ManyToOne
    private Utilisateur utilisateur2; //ce sera l'utilisateur principale

    @ManyToOne
    private TypeRelation typeRelation;





}
