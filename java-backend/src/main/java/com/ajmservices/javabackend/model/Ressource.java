package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "idType")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "IdStatutRessource")
    private EtatRessource etatRessource;

    @OneToMany(mappedBy = "ressource", cascade = CascadeType.ALL)
    private List<Commentaire> commentaires;

    @ManyToMany
    @JoinTable(name = "_LierTypeRelation",
            joinColumns = @JoinColumn(name = "idRessource"),
            inverseJoinColumns = @JoinColumn(name = "idRelation"))
    private Set<TypeRelation> typesRelation;

    @ManyToMany(mappedBy = "listeRessourceFavoris")
    private Set<Utilisateur> utilisateursAjouteFavoris;

    // Constructors
    public Ressource() {
    }

    public Ressource(String titre, String description, Date datePublication, int nbConsultation, int nbRecherche, int nbPartage, Utilisateur utilisateur, Categorie categorie, Type type, EtatRessource etatRessource) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.nbConsultation = nbConsultation;
        this.nbRecherche = nbRecherche;
        this.nbPartage = nbPartage;
        this.utilisateur = utilisateur;
        this.categorie = categorie;
        this.type = type;
        this.etatRessource = etatRessource;
    }

    // Getters and Setters
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public EtatRessource getEtatRessource() {
        return etatRessource;
    }

    public void setEtatRessource(EtatRessource etatRessource) {
        this.etatRessource = etatRessource;
    }

    public void ajouterCommentaire(Commentaire commentaire) {
        commentaires.add(commentaire);
        commentaire.setRessource(this); // Met à jour la référence à la ressource dans le commentaire
    }

    // Méthode pour retirer un commentaire de la liste
    public void retirerCommentaire(Commentaire commentaire) {
        commentaires.remove(commentaire);
        commentaire.setRessource(null); // Supprime la référence à la ressource dans le commentaire
    }

    public void setTypesRelation(Set<TypeRelation> typesRelation) {
        this.typesRelation = typesRelation;
    }

    public Set<TypeRelation> getTypesRelation() {
        return typesRelation;
    }

    // Méthode pour ajouter un type de relation
    public void ajouterTypeRelation(TypeRelation typeRelation) {
        typesRelation.add(typeRelation);
        typeRelation.getRessources().add(this);
    }

    // Méthode pour retirer un type de relation
    public void retirerTypeRelation(TypeRelation typeRelation) {
        typesRelation.remove(typeRelation);
        typeRelation.getRessources().remove(this);
    }


    // toString method
    @Override
    public String toString() {
        return "Ressource{" +
                "idRessource=" + idRessource +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                ", nbConsultation=" + nbConsultation +
                ", nbRecherche=" + nbRecherche +
                ", nbPartage=" + nbPartage +
                ", utilisateur=" + utilisateur +
                ", categorie=" + categorie +
                ", type=" + type +
                ", etatRessource=" + etatRessource +
                '}';
    }
}
