package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class RelationUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_relation_utilisateur;

    private boolean est_accepte;


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

    public Long getIdRelationUtilisateur() {
        return this.id_relation_utilisateur;
    }

    public void setIdRelationUtilisateur(Long id_relation_utilisateur) {
        this.id_relation_utilisateur = id_relation_utilisateur;
    }

    public boolean isEstAccepte() {
        return this.est_accepte;
    }

    public void setEstAccepte(boolean est_accepte) {
        this.est_accepte = est_accepte;
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

