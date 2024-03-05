package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorie;

    private String nom;

    // Constructors
    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    // Getters and Setters
    public Long getIdCategorie() {
        return idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // toString method
    @Override
    public String toString() {
        return "Categorie{" +
                "idCategorie=" + idCategorie +
                ", nom='" + nom +
                '}';
    }
}
