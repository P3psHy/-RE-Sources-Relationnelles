package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class MessageUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessageUtilisateur;

    private String contenu;
    private Date dateMessageUtilisateur;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur1")
    private Utilisateur utilisateur1;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur2")
    private Utilisateur utilisateur2;


    // Constructors
    public MessageUtilisateur() {
    }

    public MessageUtilisateur(String contenu, Date dateMessageUtilisateur,
            Utilisateur utilisateur1, Utilisateur utilisateur2) {
        this.contenu = contenu;
        this.dateMessageUtilisateur = dateMessageUtilisateur;
        this.utilisateur1 = utilisateur1;
        this.utilisateur2 = utilisateur2;
    }

    // Getters and Setters
    public Long getIdMessageUtilisateur() {
        return idMessageUtilisateur;
    }

    public void setIdMessageUtilisateur(Long idMessageUtilisateur) {
        this.idMessageUtilisateur = idMessageUtilisateur;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateMessageUtilisateur() {
        return dateMessageUtilisateur;
    }

    public void setDateMessageUtilisateur(Date dateMessageUtilisateur) {
        this.dateMessageUtilisateur = dateMessageUtilisateur;
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
                "idMessageUtilisateur=" + idMessageUtilisateur +
                ", contenu='" + contenu + '\'' +
                ", dateMessageUtilisateur='" + dateMessageUtilisateur + '\'' +
                ", utilisateur1=" + utilisateur1 + '\'' +
                ", utilisateur2=" + utilisateur2 +
                '}';
    }
}
