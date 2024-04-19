package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commentaire;

    private String contenu;
    private Date date_commentaire;

    @ManyToOne
    @JoinColumn(name = "id_ressource")
    private Ressource ressource;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;


    // Constructors
    public Commentaire() {
    }

    public Commentaire(String contenu, Date date_commentaire,
        Ressource ressource, Utilisateur utilisateur) {
        this.contenu = contenu;
        this.date_commentaire = date_commentaire;
        // Générer la date et heure du commentaire à son instanciation
        // this.dateCommentaire = new Date();
        this.ressource = ressource;
        this.utilisateur = utilisateur;
    }

    // Getters and Setters
    public Long getIdCommentaire() {
        return id_commentaire;
    }

    public void setIdCommentaire(Long id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateCommentaire() {
        return date_commentaire;
    }

    public void setDateCommentaire(Date date_commentaire) {
        this.date_commentaire = date_commentaire;
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
                "id_commentaire=" + id_commentaire +
                ", contenu='" + contenu + '\'' +
                ", date_commentaire='" + date_commentaire + '\'' +
                ", ressource=" + ressource + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
