package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reponse;

    private String contenu;
    private Date date_reponse;

    @ManyToOne
    @JoinColumn(name = "id_commentaire")
    private Commentaire commentaire;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;


    // Constructors
    public Reponse() {
    }

    public Reponse(String contenu, Date date_reponse,
            Commentaire commentaire, Utilisateur utilisateur) {
        this.contenu = contenu;
        this.date_reponse = date_reponse;
        this.commentaire = commentaire;
        this.utilisateur = utilisateur;
    }

    // Getters and Setters
    public Long getIdReponse() {
        return id_reponse;
    }

    public void setIdReponse(Long id_reponse) {
        this.id_reponse = id_reponse;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateReponse() {
        return date_reponse;
    }

    public void setDateReponse(Date date_reponse) {
        this.date_reponse = date_reponse;
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
                "id_reponse=" + id_reponse +
                ", contenu='" + contenu + '\'' +
                ", date_reponse='" + date_reponse + '\'' +
                ", commentaire=" + commentaire + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
