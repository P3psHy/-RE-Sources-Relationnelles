package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class EtatRessource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtatRessource;

    private String nom;

    // Constructors
    public EtatRessource() {
    }

    public EtatRessource(String nom) {
        this.nom = nom;
    }

    // Getters and Setters
    public Long getIdEtatRessource() {
        return idEtatRessource;
    }

    public void setIdEtatRessource(Long idEtatRessource) {
        this.idEtatRessource = idEtatRessource;
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
        return "EtatRessource{" +
                "idEtatRessource=" + idEtatRessource +
                ", nom='" + nom +
                '}';
    }
}
