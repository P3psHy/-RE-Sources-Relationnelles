package com.ajmservices.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EtatRessource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatutRessource;

    private String texte;

    // Constructors
    public EtatRessource() {
    }

    public EtatRessource(String texte) {
        this.texte = texte;
    }

    // Getters and Setters
    public int getIdStatutRessource() {
        return idStatutRessource;
    }

    public void setIdStatutRessource(int idStatutRessource) {
        this.idStatutRessource = idStatutRessource;
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
                "idStatutRessource=" + idStatutRessource +
                ", texte='" + texte + '\'' +
                '}';
    }
}

