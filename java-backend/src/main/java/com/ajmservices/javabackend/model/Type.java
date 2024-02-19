package com.ajmservices.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idType;

    private String nom;

    // Constructors
    public Type() {
    }

    public Type(String nom) {
        this.nom = nom;
    }

    // Getters and Setters
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
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
        return "Type{" +
                "idType=" + idType +
                ", nom='" + nom + '\'' +
                '}';
    }
}
