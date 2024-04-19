package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class EtatRessource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etat_ressource;

    private String nom;

    // Constructors
    public EtatRessource() {
    }

    public EtatRessource(String nom) {
        this.nom = nom;
    }

    // Getters and Setters
    public Long getIdEtatRessource() {
        return id_etat_ressource;
    }

    public void setIdEtatRessource(Long id_etat_ressource) {
        this.id_etat_ressource = id_etat_ressource;
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
                "id_etat_ressource=" + id_etat_ressource +
                ", nom='" + nom +
                '}';
    }
}
