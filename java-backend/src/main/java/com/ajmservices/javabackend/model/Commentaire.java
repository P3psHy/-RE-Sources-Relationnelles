package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommentaire;

    private String texte;
    private Date dateCommentaire;

    @ManyToOne
    @JoinColumn(name = "id_ressource")
    private Ressource ressource;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;


    // Constructors
    public Commentaire() {
    }

    public Commentaire(String texte, Date dateCommentaire,
            Ressource ressource, Utilisateur utilisateur) {
        this.texte = texte;
        this.dateCommentaire = dateCommentaire;
        this.ressource = ressource;
        this.utilisateur = utilisateur;
    }

    // Getters and Setters
    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
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
        return "Commentaire{" +
                "idCommentaire=" + idCommentaire +
                ", texte='" + texte + '\'' +
                ", dateCommentaire='" + dateCommentaire + '\'' +
                ", ressource=" + ressource + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
