package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class RelationUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRelationUtilisateur;

    private boolean estAccepte;


    @ManyToOne
    @JoinColumn(name = "id_utilisateur1")
    private Utilisateur utilisateur1;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur2")
    private Utilisateur utilisateur2;

    @ManyToOne
    @JoinColumn(name = "id_type_relation")
    private TypeRelation typeRelation;

    

    
    public RelationUtilisateur() {

    }

    public int getIdRelationUtilisateur() {
        return this.idRelationUtilisateur;
    }

    public void setIdRelationUtilisateur(int idRelationUtilisateur) {
        this.idRelationUtilisateur = idRelationUtilisateur;
    }

    public boolean isEstAccepte() {
        return this.estAccepte;
    }

    public void setEstAccepte(boolean estAccepte) {
        this.estAccepte = estAccepte;
    }

    public Utilisateur getUtilisateur1() {
        return this.utilisateur1;
    }

    public void setUtilisateur1(Utilisateur utilisateur1) {
        this.utilisateur1 = utilisateur1;
    }

    public Utilisateur getUtilisateur2() {
        return this.utilisateur2;
    }

    public void setUtilisateur2(Utilisateur utilisateur2) {
        this.utilisateur2 = utilisateur2;
    }

    public TypeRelation getTypeRelation() {
        return this.typeRelation;
    }

    public void setTypeRelation(TypeRelation typeRelation) {
        this.typeRelation = typeRelation;
    }

}

