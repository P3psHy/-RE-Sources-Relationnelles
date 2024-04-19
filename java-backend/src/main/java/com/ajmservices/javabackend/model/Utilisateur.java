package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_utilisateur;

    private String nom;
    private String prenom;
    private String mail;
    private String mot_de_passe;
    private String departement;
    private boolean est_active;
    private Date date_desactivation;
    private Date date_creation;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    @OneToMany(mappedBy = "utilisateur")
    @JsonManagedReference
    private Set<Ressource> ressources = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "_utilisateur_ressource_favoris", joinColumns = @JoinColumn(name = "id_utilisateur"), inverseJoinColumns = @JoinColumn(name = "id_ressource"))
    private Set<Ressource> ressourcesFavoris = new HashSet<>();

    @OneToMany(mappedBy = "utilisateur1", fetch = FetchType.EAGER)
    private Collection<MessageUtilisateur> envoyes;

    @OneToMany(mappedBy = "utilisateur2", fetch = FetchType.EAGER)
    private Collection<MessageUtilisateur> recus;

    @OneToMany(mappedBy = "utilisateur1")
    private Set<RelationUtilisateur> relations1 = new HashSet<>();

    @OneToMany(mappedBy = "utilisateur2")
    private Set<RelationUtilisateur> relations2 = new HashSet<>();

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String mail, String mot_de_passe, String departement, boolean est_active,
            Date date_creation, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mot_de_passe = mot_de_passe;
        this.departement = departement;
        this.est_active = est_active;
        this.date_creation = date_creation;
        this.role = role;
    }

    // Getters and Setters
    public Long getIdUtilisateur() {
        return id_utilisateur;
    }

    public void setIdUtilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
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
        return mot_de_passe;
    }

    public void setMotDePasse(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public boolean getEstActive() {
        return est_active;
    }

    public void setEstActive(boolean est_active) {
        this.est_active = est_active;
    }

    public Date getDateDesactivation() {
        return date_desactivation;
    }

    public void setDateDesactivation(Date date_desactivation) {
        this.date_desactivation = date_desactivation;
    }

    public Date getDateCreation() {
        return date_creation;
    }

    public void setDateCreation(Date date_creation) {
        this.date_creation = date_creation;
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

    public void ajouterRessourceFavoris(Ressource ressource) {
        ressourcesFavoris.add(ressource);
        // ressource.getUtilisateursFavoris().add(this); // Met à jour l'autre côté de la relation
    }

    // Méthode pour retirer une ressource des favoris de l'utilisateur
    public void retirerRessourceFavoris(Ressource ressource) {
        ressourcesFavoris.remove(ressource);
        // ressource.getUtilisateursFavoris().remove(this); // Met à jour l'autre côté de la relation
    }

    // toString method
    @Override
    public String toString() {
        return "Utilisateur{" +
                "id_utilisateur=" + id_utilisateur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", departement='" + departement + '\'' +
                ", est_active=" + est_active + '\'' +
                ", date_desactivation=" + date_desactivation + '\'' +
                ", date_creation=" + date_creation + '\'' +
                ", role=" + role +
                '}';
    }
}
