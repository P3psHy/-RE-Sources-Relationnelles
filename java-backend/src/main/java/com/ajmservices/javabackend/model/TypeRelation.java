package com.ajmservices.javabackend.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class TypeRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeRelation;

    private String titre;
    private String description;

    public TypeRelation() {
    }

    public TypeRelation(String titre, String description) {
        this.titre = titre;
        this.description = description;

    }

    // Getters and Setters
    public Long getIdTypeRelation() {
        return this.idTypeRelation;
    }

    public void setIdTypeRelation(Long idTypeRelation) {
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

    @ManyToMany(mappedBy = "linkedTypeRelations")
    Set<Ressource> linkedRessources;

    // toString method
    @Override
    public String toString() {
        return "TypeRelation{" +
                "idTypeRelation=" + idTypeRelation +
                ", titre='" + titre + '\'' +
                ", description='" + description +
                '}';
    }

}
