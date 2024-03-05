package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;

    private String nom;
    private String prenom;
    private String mail;
    private String motDePasse;
    private String departement;
    private boolean statut;
    private Date dateDesactivation;
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Ressource> ressources = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "_utilisateur_ressource_favoris",
               joinColumns = @JoinColumn(name = "id_utilisateur"),
               inverseJoinColumns = @JoinColumn(name = "id_ressource"))
    private Set<Ressource> ressourcesFavoris = new HashSet<>();

    @OneToMany(mappedBy="utilisateur1", fetch = FetchType.EAGER)
    private Collection<MessageUtilisateur> envoyes;

    @OneToMany(mappedBy="utilisateur2", fetch = FetchType.EAGER)
    private Collection<MessageUtilisateur> recus;


    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String mail, String motDePasse, String departement, boolean statut,
            Date dateCreation, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.departement = departement;
        this.statut = statut;
        this.dateCreation = dateCreation;
        this.role = role;
    }

    // Getters and Setters
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public Date getDateDesactivation() {
        return dateDesactivation;
    }

    public void setDateDesactivation(Date dateDesactivation) {
        this.dateDesactivation = dateDesactivation;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Ressource> getRessources() {
        return ressources;
    }

    // Setter pour ressources
    public void setRessources(Set<Ressource> ressources) {
        this.ressources = ressources;
    }

    public Set<Ressource> getRessourcesFavoris() {
        return ressourcesFavoris;
    }

    // Setter pour ressourcesFavoris
    public void setRessourcesFavoris(Set<Ressource> ressourcesFavoris) {
        this.ressourcesFavoris = ressourcesFavoris;
    }

    // toString method
    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur=" + idUtilisateur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", departement='" + departement + '\'' +
                ", statut=" + statut + '\'' +
                ", dateDesactivation=" + dateDesactivation + '\'' +
                ", dateCreation=" + dateCreation + '\'' +
                ", role=" + role +
                '}';
    }
}
