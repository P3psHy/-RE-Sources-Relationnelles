package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReponse;

    private String contenu;
    private Date dateReponse;

    @ManyToOne
    @JoinColumn(name = "id_commentaire")
    private Commentaire commentaire;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;


    // Constructors
    public Reponse() {
    }

    public Reponse(String contenu, Date dateReponse,
            Commentaire commentaire, Utilisateur utilisateur) {
        this.contenu = contenu;
        this.dateReponse = dateReponse;
        this.commentaire = commentaire;
        this.utilisateur = utilisateur;
    }

    // Getters and Setters
    public Long getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Long idReponse) {
        this.idReponse = idReponse;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(Date dateReponse) {
        this.dateReponse = dateReponse;
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
                ", contenu='" + contenu + '\'' +
                ", dateReponse='" + dateReponse + '\'' +
                ", commentaire=" + commentaire + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
