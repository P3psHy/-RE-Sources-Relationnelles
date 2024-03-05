package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class EtatRessource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatusRessource;

    private String texte;

    // Constructors
    public EtatRessource() {
    }

    public EtatRessource(String texte) {
        this.texte = texte;
    }

    // Getters and Setters
    public int getidStatusRessource() {
        return idStatusRessource;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    // toString method
    @Override
    public String toString() {
        return "EtatRessource{" +
                "idStatusRessource=" + idStatusRessource +
                ", texte='" + texte +
                '}';
    }
}
