package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRessource;

    private String titre;
    private String description;
    private Date datePublication;
    private int nbConsultation;
    private int nbRecherche;
    private int nbPartage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "id_type_ressource")
    private TypeRessource typeRessource;

    @ManyToOne
    @JoinColumn(name = "id_etat_ressource")
    private EtatRessource etatRessource;

    @OneToOne(mappedBy = "ressource", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Fichier fichier;

    @OneToMany(mappedBy = "ressource")
    private Set<Commentaire> commentaires = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "_lier_ressource_type_relation", joinColumns = @JoinColumn(name = "idRessource"), inverseJoinColumns = @JoinColumn(name = "id_type_relation"))
    Set<TypeRelation> linkedTypeRelations;

    public Ressource(){

    };

    // public Ressource(String titre, String description, Date datePublication, int nbConsultation,
    //         int nbRecherche, int nbPartage, Utilisateur utilisateur, Categorie categorie, TypeRessource typeRessource,
    //         Fichier fichier) {

    public Ressource(String titre, String description, Date datePublication, int nbConsultation,
            int nbRecherche, int nbPartage, Utilisateur utilisateur, Categorie categorie, TypeRessource typeRessource,
            EtatRessource etatRessource) {

        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.nbConsultation = nbConsultation;
        this.nbRecherche = nbRecherche;
        this.nbPartage = nbPartage;
        this.utilisateur = utilisateur;
        this.categorie = categorie;
        this.typeRessource = typeRessource;
        this.etatRessource = etatRessource;
    };

    public Long getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(Long idRessource) {
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

    public Set<Commentaire> getCommentaires() {
        return commentaires;
    }

    // toString method
    @Override
    public String toString() {
        return "Ressource{" +
                "idRessource=" + idRessource +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", datePublication='" + datePublication + '\'' +
                ", nbConsultation='" + nbConsultation + '\'' +
                ", nbPartage='" + nbPartage + '\'' +
                ", nbRecherche=" + nbRecherche + '\'' +
                ", utilisateur=" + utilisateur + '\'' +
                ", categorie=" + categorie + '\'' +
                ", typeRessource=" + typeRessource + '\'' +
                ", fichier=" + fichier + '\'' +
                ", commentaires=" + commentaires +
                '}';
    }
}
