package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity

public class Fichier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFichier;

    private String nom;
    private float tailleFichier;

    @OneToOne
    @JoinColumn(name = "id_ressource")
    private Ressource ressource;

    public Fichier() {
    }

    public Fichier(String nom) {
        this.nom = nom;
    }

    // Getters and Setters
    public Long getIdFichier() {
        return this.idFichier;
    }

    public String getNom() {
        return nom;
    }

    public void setTexte(String nom) {
        this.nom = nom;
    }

    public Float getTailleFichier() {
        return tailleFichier;
    }

    public void setTailleFichier(Float tailleFichier) {
        this.tailleFichier = tailleFichier;
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
        return "EtatRessource{" +
                "idFichier=" + idFichier +
                ", nom='" + nom +
                ", tailleFichier='" + tailleFichier +
                '}';
    }

}
