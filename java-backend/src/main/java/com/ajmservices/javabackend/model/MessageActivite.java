package com.ajmservices.javabackend.model;

import java.util.Date;

import jakarta.persistence.*;



@Entity
public class MessageActivite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_message_activite;

    private String contenu;
    private Date date_message_activite;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_ressource")
    private Activite activite;


    // Constructors
    public MessageActivite() {
    }

    public MessageActivite(String contenu, Date date_message_activite,
            Utilisateur utilisateur, Activite activite) {
        this.contenu = contenu;
        this.date_message_activite = date_message_activite;
        this.utilisateur = utilisateur;
        this.activite = activite;
    }

    // Getters and Setters
    public Long getIdMessageActivite() {
        return id_message_activite;
    }

    public void setIdMessageActivite(Long id_message_activite) {
        this.id_message_activite = id_message_activite;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateMessageActivite() {
        return date_message_activite;
    }

    public void setDateMessageActivite(Date date_message_activite) {
        this.date_message_activite = date_message_activite;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    // toString method
    @Override
    public String toString() {
        return "MessageActivite{" +
                "id_message_activite=" + id_message_activite +
                ", contenu='" + contenu + '\'' +
                ", date_message_activite='" + date_message_activite + '\'' +
                ", utilisateur=" + utilisateur + '\'' +
                ", activite=" + activite +
                '}';
    }
}
