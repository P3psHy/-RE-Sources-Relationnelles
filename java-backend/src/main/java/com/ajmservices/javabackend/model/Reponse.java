package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReponse;

    private String texte;
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

    public Reponse(String texte, Date dateReponse,
            Commentaire commentaire, Utilisateur utilisateur) {
        this.texte = texte;
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

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
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
                ", texte='" + texte + '\'' +
                ", dateReponse='" + dateReponse + '\'' +
                ", commentaire=" + commentaire + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
