package com.ajmservices.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idType;

    private String nom;

    @OneToOne
    @JoinColumn(name = "idType")
    private Type type;

    // Constructors
    public Activite() {
    }

    public Activite(int idType, String nom, Type type) {
        this.idType = idType;
        this.nom = nom;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    // toString method
    @Override
    public String toString() {
        return "Activite{" +
                "idType=" + idType +
                ", nom='" + nom + '\'' +
                ", type=" + type +
                '}';
    }
}
