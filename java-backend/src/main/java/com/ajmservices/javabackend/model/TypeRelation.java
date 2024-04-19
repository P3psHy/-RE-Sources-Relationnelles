package com.ajmservices.javabackend.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class TypeRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type_relation;

    private String nom;
    private String commentaire;

    public TypeRelation() {
    }

    public TypeRelation(String nom, String commentaire) {
        this.nom = nom;
        this.commentaire = commentaire;

    }

    // Getters and Setters
    public Long getIdTypeRelation() {
        return this.id_type_relation;
    }

    public void setIdTypeRelation(Long id_type_relation) {
        this.id_type_relation = id_type_relation;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @ManyToMany(mappedBy = "linkedTypeRelations")
    Set<Ressource> linkedRessources;

    // toString method
    @Override
    public String toString() {
        return "TypeRelation{" +
                "id_type_relation=" + id_type_relation +
                ", nom='" + nom + '\'' +
                ", commentaire='" + commentaire +
                '}';
    }

}
