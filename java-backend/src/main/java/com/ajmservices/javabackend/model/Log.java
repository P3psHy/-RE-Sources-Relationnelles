package com.ajmservices.javabackend.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_log;

    private String contenu;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    private Date date_log;

    // Constructors
    public Log() {
    }

    public Log(String contenu, Utilisateur utilisateur, Date date_log) {
        this.contenu = contenu;
        this.utilisateur = utilisateur;
        this.date_log = date_log;
    }

    // Getters and Setters
    public Long getIdLog() {
        return id_log;
    }

    public void setIdLog(Long id_log) {
        this.id_log = id_log;
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

    public Date getDateLog() {
        return date_log;
    }

    public void setDateLog(Date date_log) {
        this.date_log = date_log;
    }

    // toString method
    @Override
    public String toString() {
        return "Log{" +
                "id_log=" + id_log +
                ", contenu='" + contenu + '\'' +
                ", utilisateur=" + utilisateur + '\'' +
                ", date_log=" + date_log +
                '}';
    }
}
