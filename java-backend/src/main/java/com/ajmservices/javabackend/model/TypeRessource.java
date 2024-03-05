package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class TypeRessource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeRessource;

    private String nom;

    public TypeRessource() {
    }

    public TypeRessource(String nom){
        this.nom = nom;

    }

    // Getters and Setters
    public int getIdTypeRessource() {
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

        // toString method
        @Override
        public String toString() {
            return "TypeRessource{" +
                    "idTypeRessource=" + idTypeRessource +
                    ", nom='" + nom +
                    '}';
        }

}
