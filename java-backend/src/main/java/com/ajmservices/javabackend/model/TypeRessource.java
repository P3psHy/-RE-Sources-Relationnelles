package com.ajmservices.javabackend.model;

import jakarta.persistence.*;


public class TypeRessource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeRessource;

    private String nom;


    public TypeRessource(String nom){
        this.nom = nom;

    }

    // Getters and Setters
    public int getID() {
        return this.idTypeRessource;
    }

    public void setIdTypeRessource(int idTypeRessource) {
        this.idTypeRessource = idTypeRessource;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
