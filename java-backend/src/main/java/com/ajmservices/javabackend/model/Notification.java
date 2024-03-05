package com.ajmservices.javabackend.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotification;

    private String titre;
    private String texte;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    private Date dateNotification;

    // Constructors
    public Notification() {
    }

    public Notification(String titre, String texte, Utilisateur utilisateur, Date dateNotification) {
        this.titre = titre;
        this.texte = texte;
        this.utilisateur = utilisateur;
        this.dateNotification = dateNotification;
    }

    // Getters and Setters
    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public String getTitre() {
        return texte;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
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
                ", texte='" + texte + '\'' +
                ", utilisateur=" + utilisateur + '\'' +
                ", dateNotification=" + dateNotification +
                '}';
    }
}
