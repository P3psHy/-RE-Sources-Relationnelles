package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRessource;

    private String titre;
    private String description;
    private Date datePublication;
    private int nbConsultation;
    private int nbRecherche;
    private int nbPartage;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_fichier", referencedColumnName = "id_ressource")
    private Fichier fichier;

    public int getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(int idRessource) {
        this.idRessource = idRessource;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public int getNbConsultation() {
        return nbConsultation;
    }

    public void setNbConsultation(int nbConsultation) {
        this.nbConsultation = nbConsultation;
    }

    public int getNbRecherche() {
        return nbRecherche;
    }

    public void setNbRecherche(int nbRecherche) {
        this.nbRecherche = nbRecherche;
    }

    public int getNbPartage() {
        return nbPartage;
    }

    public void setNbPartage(int nbPartage) {
        this.nbPartage = nbPartage;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Fichier getFichier() {
        return fichier;
    }

    // Setter pour fichier
    public void setFichier(Fichier fichier) {
        this.fichier = fichier;
    }
}
