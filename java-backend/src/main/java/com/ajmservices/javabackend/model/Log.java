package com.ajmservices.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLog;

    @Column(length = 10000)
    private String textLog;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    // Constructors
    public Log() {
    }

    public Log(String textLog, Utilisateur utilisateur) {
        this.textLog = textLog;
        this.utilisateur = utilisateur;
    }

    // Getters and Setters
    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
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

    // toString method
    @Override
    public String toString() {
        return "Log{" +
                "idLog=" + idLog +
                ", textLog='" + textLog + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
