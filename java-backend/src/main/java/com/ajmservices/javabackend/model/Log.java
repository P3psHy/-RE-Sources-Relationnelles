package com.ajmservices.javabackend.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLog;

    private String textLog;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    private Date dateLog;

    // Constructors
    public Log() {
    }

    public Log(String textLog, Utilisateur utilisateur, Date dateLog) {
        this.textLog = textLog;
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

    public String getTextLog() {
        return textLog;
    }

    public void setTextLog(String textLog) {
        this.textLog = textLog;
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
                ", textLog='" + textLog + '\'' +
                ", utilisateur=" + utilisateur + '\'' +
                ", dateLog=" + dateLog +
                '}';
    }
}
