package com.ajmservices.javabackend.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotification;

    private String titre;
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    private Date dateNotification;

    // Constructors
    public Notification() {
    }

    public Notification(String titre, String contenu, Utilisateur utilisateur, Date dateNotification) {
        this.titre = titre;
        this.contenu = contenu;
        this.utilisateur = utilisateur;
        this.dateNotification = dateNotification;
    }

    // Getters and Setters
    public Long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Long idNotification) {
        this.idNotification = idNotification;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDateNotification() {
        return dateNotification;
    }

    public void setDateNotification(Date dateNotification) {
        this.dateNotification = dateNotification;
    }

    // toString method
    @Override
    public String toString() {
        return "Notification{" +
                "idNotification=" + idNotification +
                ", titre='" + titre + '\'' +
                ", contenu='" + contenu + '\'' +
                ", utilisateur=" + utilisateur + '\'' +
                ", dateNotification=" + dateNotification +
                '}';
    }
}
