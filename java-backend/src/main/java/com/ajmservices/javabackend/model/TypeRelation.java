package com.ajmservices.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;


@Entity
public class TypeRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRelation;

    private String titre;
    private String description;

    @ManyToMany(mappedBy = "typesRelation")
    private Set<Ressource> ressources;

    private Set<EtreEnRelation> listeTypeRelation;


    // Constructors
    public TypeRelation() {
    }

    public TypeRelation(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    // Getters and Setters
    public int getIdRelation() {
        return idRelation;
    }

    public void setIdRelation(int idRelation) {
        this.idRelation = idRelation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRessources(Set<Ressource> ressources) {
        this.ressources = ressources;
    }

    public Set<Ressource> getRessources() {
        return ressources;
    }

    // Méthode pour ajouter une ressource
    public void ajouterRessource(Ressource ressource) {
        ressources.add(ressource);
        ressource.getTypesRelation().add(this);
    }

    // Méthode pour retirer une ressource
    public void retirerRessource(Ressource ressource) {
        ressources.remove(ressource);
        ressource.getTypesRelation().remove(this);
    }

    public Set<EtreEnRelation> getlisteTypeRelation(){
        return listeTypeRelation;
    }

    // toString method
    @Override
    public String toString() {
        return "TypeRelation{" +
                "idRelation=" + idRelation +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

