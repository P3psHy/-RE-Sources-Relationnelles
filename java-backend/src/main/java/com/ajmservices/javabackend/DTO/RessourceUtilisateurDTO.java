package com.ajmservices.javabackend.DTO;

import java.util.Date;

public class RessourceUtilisateurDTO {
    private Long idRessource;
    private String titre;
    private String description;
    private Date datePublication;
    private int nbConsultation;
    private int nbRecherche;
    private int nbPartage;
    private String nomUtilisateur;
    private String prenomUtilisateur;

    public RessourceUtilisateurDTO(){

    }


    public Long getIdRessource() {
        return this.idRessource;
    }

    public void setIdRessource(Long idRessource) {
        this.idRessource = idRessource;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublication() {
        return this.datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public int getNbConsultation() {
        return this.nbConsultation;
    }

    public void setNbConsultation(int nbConsultation) {
        this.nbConsultation = nbConsultation;
    }

    public int getNbRecherche() {
        return this.nbRecherche;
    }

    public void setNbRecherche(int nbRecherche) {
        this.nbRecherche = nbRecherche;
    }

    public int getNbPartage() {
        return this.nbPartage;
    }

    public void setNbPartage(int nbPartage) {
        this.nbPartage = nbPartage;
    }

    public String getNomUtilisateur() {
        return this.nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return this.prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

}