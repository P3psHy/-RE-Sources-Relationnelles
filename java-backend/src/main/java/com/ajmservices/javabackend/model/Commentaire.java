package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommentaire;

    private String contenu;
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

    public Commentaire(String contenu, Date dateCommentaire,
        Ressource ressource, Utilisateur utilisateur) {
        this.contenu = contenu;
        this.dateCommentaire = dateCommentaire;
        // Générer la date et heure du commentaire à son instanciation
        // this.dateCommentaire = new Date();
        this.ressource = ressource;
        this.utilisateur = utilisateur;
    }

    // Getters and Setters
    public Long getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(Long idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
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
                ", contenu='" + contenu + '\'' +
                ", dateCommentaire='" + dateCommentaire + '\'' +
                ", ressource=" + ressource + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
