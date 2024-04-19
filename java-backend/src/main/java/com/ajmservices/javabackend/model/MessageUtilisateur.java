package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class MessageUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_message_utilisateur;

    private String contenu;
    private Date date_message_utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur1")
    private Utilisateur utilisateur1;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur2")
    private Utilisateur utilisateur2;


    // Constructors
    public MessageUtilisateur() {
    }

    public MessageUtilisateur(String contenu, Date date_message_utilisateur,
            Utilisateur utilisateur1, Utilisateur utilisateur2) {
        this.contenu = contenu;
        this.date_message_utilisateur = date_message_utilisateur;
        this.utilisateur1 = utilisateur1;
        this.utilisateur2 = utilisateur2;
    }

    // Getters and Setters
    public Long getIdMessageUtilisateur() {
        return id_message_utilisateur;
    }

    public void setIdMessageUtilisateur(Long id_message_utilisateur) {
        this.id_message_utilisateur = id_message_utilisateur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateMessageUtilisateur() {
        return date_message_utilisateur;
    }

    public void setDateMessageUtilisateur(Date date_message_utilisateur) {
        this.date_message_utilisateur = date_message_utilisateur;
    }

    public Utilisateur getUtilisateur1() {
        return utilisateur1;
    }

    public void setUtilisateur1(Utilisateur utilisateur1) {
        this.utilisateur1 = utilisateur1;
    }
    
    public Utilisateur getUtilisateur2() {
        return utilisateur2;
    }

    public void setUtilisateur2(Utilisateur utilisateur2) {
        this.utilisateur2 = utilisateur2;
    }

    // toString method
    @Override
    public String toString() {
        return "MessageUtilisateur{" +
                "id_message_utilisateur=" + id_message_utilisateur +
                ", contenu='" + contenu + '\'' +
                ", date_message_utilisateur='" + date_message_utilisateur + '\'' +
                ", utilisateur1=" + utilisateur1 + '\'' +
                ", utilisateur2=" + utilisateur2 +
                '}';
    }
}
