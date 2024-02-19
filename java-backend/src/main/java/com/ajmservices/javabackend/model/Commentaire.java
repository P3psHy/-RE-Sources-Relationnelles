package com.ajmservices.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommentaire;

    @Column(length = 1000)
    private String texte;

    @ManyToOne
    @JoinColumn(name = "idRessource")
    private Ressource ressource;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "commentaire", cascade = CascadeType.ALL)
    private List<Reponse> reponses;

    // Constructors
    public Commentaire() {
    }

    public Commentaire(String texte, Ressource ressource, Utilisateur utilisateur) {
        this.texte = texte;
        this.ressource = ressource;
        this.utilisateur = utilisateur;
    }

    // Getters and Setters
    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Méthode pour ajouter une réponse à la liste de réponses
    public void ajouterReponse(Reponse reponse) {
        reponses.add(reponse);
        reponse.setCommentaire(this); // Met à jour la référence au commentaire dans la réponse
    }

    // Méthode pour retirer une réponse de la liste de réponses
    public void retirerReponse(Reponse reponse) {
        reponses.remove(reponse);
        reponse.setCommentaire(null); // Supprime la référence au commentaire dans la réponse
    }


    // toString method
    @Override
    public String toString() {
        return "Commentaire{" +
                "idCommentaire=" + idCommentaire +
                ", texte='" + texte + '\'' +
                ", ressource=" + ressource +
                ", utilisateur=" + utilisateur +
                '}';
    }
}

