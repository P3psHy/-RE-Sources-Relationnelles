package com.ajmservices.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;



@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReponse;

    @Column(length = 1000)
    private String texte;

    @ManyToOne
    @JoinColumn(name = "IdCommentaire")
    private Commentaire commentaire;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;


    // Constructors
    public Reponse() {
    }

    public Reponse(String texte, Commentaire commentaire, Utilisateur utilisateur) {
        this.texte = texte;
        this.commentaire = commentaire;
        this.utilisateur = utilisateur;
    }

    // Getters and Setters
    public int getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // toString method
    @Override
    public String toString() {
        return "Reponse{" +
                "idReponse=" + idReponse +
                ", texte='" + texte + '\'' +
                ", commentaire=" + commentaire +
                ", utilisateur=" + utilisateur +
                '}';
    }
}

