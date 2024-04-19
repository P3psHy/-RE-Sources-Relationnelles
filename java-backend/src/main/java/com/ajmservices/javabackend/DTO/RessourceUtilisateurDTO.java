package com.ajmservices.javabackend.DTO;

import java.util.Date;

public class RessourceUtilisateurDTO {
    private Long id_ressource;
    private String titre;
    private String description;
    private Date date_publication;
    private int nb_consultation;
    private int nb_recherche;
    private int nb_Partage;
    private String nom_utilisateur;
    private String prenom_utilisateur;

    public RessourceUtilisateurDTO(){

    }


    public Long getIdRessource() {
        return this.id_ressource;
    }

    public void setIdRessource(Long id_ressource) {
        this.id_ressource = id_ressource;
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
        return this.date_publication;
    }

    public void setDatePublication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public int getNbConsultation() {
        return this.nb_consultation;
    }

    public void setNbConsultation(int nb_consultation) {
        this.nb_consultation = nb_consultation;
    }

    public int getNbRecherche() {
        return this.nb_recherche;
    }

    public void setNbRecherche(int nb_recherche) {
        this.nb_recherche = nb_recherche;
    }

    public int getNbPartage() {
        return this.nb_Partage;
    }

    public void setNbPartage(int nb_Partage) {
        this.nb_Partage = nb_Partage;
    }

    public String getNomUtilisateur() {
        return this.nom_utilisateur;
    }

    public void setNomUtilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public String getPrenomUtilisateur() {
        return this.prenom_utilisateur;
    }

    public void setPrenomUtilisateur(String prenom_utilisateur) {
        this.prenom_utilisateur = prenom_utilisateur;
    }

}