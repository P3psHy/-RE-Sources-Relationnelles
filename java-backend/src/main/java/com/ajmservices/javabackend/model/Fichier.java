package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity

public class Fichier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fichier;

    private String nom;
    private float taille_fichier;

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
        return this.id_fichier;
    }

    public void setIdFichier(Long id_fichier) {
        this.id_fichier = id_fichier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getTailleFichier() {
        return taille_fichier;
    }

    public void setTailleFichier(Float taille_fichier) {
        this.taille_fichier = taille_fichier;
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
                "id_fichier=" + id_fichier +
                ", nom='" + nom +
                ", taille_fichier='" + taille_fichier +
                '}';
    }

}
