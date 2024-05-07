package com.ajmservices.javabackend.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLog;

    private String contenu;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    private Date dateLog;

    // Constructors
    public Log() {
    }

    public Log(String contenu, Utilisateur utilisateur, Date dateLog) {
        this.contenu = contenu;
        this.utilisateur = utilisateur;
        this.dateLog = dateLog;
    }

    // Getters and Setters
    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
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
        return dateLog;
    }

    public void setDateLog(Date dateLog) {
        this.dateLog = dateLog;
    }

    // toString method
    @Override
    public String toString() {
        return "Log{" +
                "idLog=" + idLog +
                ", contenu='" + contenu + '\'' +
                ", utilisateur=" + utilisateur + '\'' +
                ", dateLog=" + dateLog +
                '}';
    }
}
