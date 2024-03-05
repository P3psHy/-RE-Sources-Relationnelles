package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class EtatRessource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtatRessource;

    private String texte;

    // Constructors
    public EtatRessource() {
    }

    public EtatRessource(String texte) {
        this.texte = texte;
    }

    // Getters and Setters
    public Long getIdEtatRessource() {
        return idEtatRessource;
    }

    public void setIdEtatRessource(Long idEtatRessource) {
        this.idEtatRessource = idEtatRessource;
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
                "idEtatRessource=" + idEtatRessource +
                ", texte='" + texte +
                '}';
    }
}