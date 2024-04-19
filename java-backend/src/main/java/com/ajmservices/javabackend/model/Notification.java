package com.ajmservices.javabackend.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_notification;

    private String titre;
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    private Date date_notification;

    // Constructors
    public Notification() {
    }

    public Notification(String titre, String contenu, Utilisateur utilisateur, Date date_notification) {
        this.titre = titre;
        this.contenu = contenu;
        this.utilisateur = utilisateur;
        this.date_notification = date_notification;
    }

    // Getters and Setters
    public Long getIdNotification() {
        return id_notification;
    }

    public void setIdNotification(Long id_notification) {
        this.id_notification = id_notification;
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
        return date_notification;
    }

    public void setDateNotification(Date date_notification) {
        this.date_notification = date_notification;
    }

    // toString method
    @Override
    public String toString() {
        return "Notification{" +
                "id_notification=" + id_notification +
                ", titre='" + titre + '\'' +
                ", contenu='" + contenu + '\'' +
                ", utilisateur=" + utilisateur + '\'' +
                ", date_notification=" + date_notification +
                '}';
    }
}
