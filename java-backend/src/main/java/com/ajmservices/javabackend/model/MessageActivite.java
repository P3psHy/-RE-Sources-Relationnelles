package com.ajmservices.javabackend.model;

import java.util.Date;

import jakarta.persistence.*;



@Entity
public class MessageActivite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessageActivite;

    private String contenu;
    private Date dateMessageActivite;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_ressource")
    private Activite activite;


    // Constructors
    public MessageActivite() {
    }

    public MessageActivite(String contenu, Date dateMessageActivite,
            Utilisateur utilisateur, Activite activite) {
        this.contenu = contenu;
        this.dateMessageActivite = dateMessageActivite;
        this.utilisateur = utilisateur;
        this.activite = activite;
    }

    // Getters and Setters
    public Long getIdMessageActivite() {
        return idMessageActivite;
    }

    public void setIdMessageActivite(Long idMessageActivite) {
        this.idMessageActivite = idMessageActivite;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateMessageActivite() {
        return dateMessageActivite;
    }

    public void setDateMessageActivite(Date dateMessageActivite) {
        this.dateMessageActivite = dateMessageActivite;
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
                "idMessageActivite=" + idMessageActivite +
                ", contenu='" + contenu + '\'' +
                ", dateMessageActivite='" + dateMessageActivite + '\'' +
                ", utilisateur=" + utilisateur + '\'' +
                ", activite=" + activite +
                '}';
    }
}
