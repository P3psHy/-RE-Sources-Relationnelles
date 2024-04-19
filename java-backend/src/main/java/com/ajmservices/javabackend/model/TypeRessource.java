package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class TypeRessource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type_ressource;

    private String nom;

    public TypeRessource() {
    }

    public TypeRessource(String nom){
        this.nom = nom;

    }

    // Getters and Setters
    public Long getIdTypeRessource() {
        return this.id_type_ressource;
    }

    public void setIdTypeRessource(Long id_type_ressource) {
        this.id_type_ressource = id_type_ressource;
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
                    "id_type_ressource=" + id_type_ressource +
                    ", nom='" + nom +
                    '}';
        }

}
