package com.ajmservices.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

@Entity
public class Fichier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFichier;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "idRessource")
    private Ressource ressource;

    // Constructors
    public Fichier() {
    }

    public Fichier(String nom, Ressource ressource) {
        this.nom = nom;
        this.ressource = ressource;
    }

    // Getters and Setters
    public int getIdFichier() {
        return idFichier;
    }

    public void setIdFichier(int idFichier) {
        this.idFichier = idFichier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    // toString method
    @Override
    public String toString() {
        return "Fichier{" +
                "idFichier=" + idFichier +
                ", nom='" + nom + '\'' +
                ", ressource=" + ressource +
                '}';
    }
}
