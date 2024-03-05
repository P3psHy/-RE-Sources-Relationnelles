package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class TypeRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeRelation;

    private String titre;
    private String description;

    public TypeRelation() {
    }

    public TypeRelation(String titre, String description) {
        this.titre = titre;
        this.description = description;

    }

    // Getters and Setters
    public int getID() {
        return this.idTypeRelation;
    }

    public void setIdTypeRelation(int idTypeRelation) {
        this.idTypeRelation = idTypeRelation;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

        // toString method
        @Override
        public String toString() {
            return "TypeRelation{" +
                    "idTypeRelation=" + idTypeRelation +
                    ", titre='" + titre +
                    ", description='" + description +
                    '}';
        }

}
