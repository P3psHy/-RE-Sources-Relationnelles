package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idType;

    private String nom;

    // Constructors
    public Activite() {
    }

    public Activite(String nom) {
        this.nom = nom;
    }

    // Getters and Setters
    public int getIdType() {
        return idType;
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
        return "Activite{" +
                "idType=" + idType +
                ", nom='" + nom +
                '}';
    }
}
