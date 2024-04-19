package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ressource;

    private String titre;
    private String description;
    private Date date_publication;
    private int nb_consultation;
    private int nb_recherche;
    private int nb_partage;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    @JsonBackReference
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
    @JoinTable(name = "_lier_ressource_type_relation", joinColumns = @JoinColumn(name = "id_ressource"), inverseJoinColumns = @JoinColumn(name = "id_type_relation"))
    Set<TypeRelation> linkedTypeRelations;

    public Ressource(){

    };

    public Ressource(String titre, String description, Date date_publication, int nb_consultation,
            int nb_recherche, int nb_partage, Utilisateur utilisateur, Categorie categorie, TypeRessource typeRessource,
            EtatRessource etatRessource) {
        this.titre = titre;
        this.description = description;
        this.date_publication = date_publication;
        this.nb_consultation = nb_consultation;
        this.nb_recherche = nb_recherche;
        this.nb_partage = nb_partage;
        this.utilisateur = utilisateur;
        this.categorie = categorie;
        this.typeRessource = typeRessource;
        this.etatRessource = etatRessource;
    };

    public Long getIdRessource() {
        return id_ressource;
    }

    public void setIdRessource(Long id_ressource) {
        this.id_ressource = id_ressource;
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
        return date_publication;
    }

    public void setDatePublication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public int getNbConsultation() {
        return nb_consultation;
    }

    public void setNbConsultation(int nb_consultation) {
        this.nb_consultation = nb_consultation;
    }

    public int getNbRecherche() {
        return nb_recherche;
    }

    public void setNbRecherche(int nb_recherche) {
        this.nb_recherche = nb_recherche;
    }

    public int getNbPartage() {
        return nb_partage;
    }

    public void setNbPartage(int nb_partage) {
        this.nb_partage = nb_partage;
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
                "id_ressource=" + id_ressource +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", date_publication='" + date_publication + '\'' +
                ", nb_consultation='" + nb_consultation + '\'' +
                ", nb_partage='" + nb_partage + '\'' +
                ", nb_recherche=" + nb_recherche + '\'' +
                ", utilisateur=" + utilisateur + '\'' +
                ", categorie=" + categorie + '\'' +
                ", typeRessource=" + typeRessource + '\'' +
                ", fichier=" + fichier + '\'' +
                ", commentaires=" + commentaires +
                '}';
    }
}
