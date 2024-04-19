package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categorie;

    private String nom;

    // Constructors
    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    // Getters and Setters
    public Long getIdCategorie() {
        return id_categorie;
    }

    public void setIdCategorie(Long id_categorie) {
        this.id_categorie = id_categorie;
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
                "id_categorie=" + id_categorie +
                ", nom='" + nom +
                '}';
    }
}
