package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    private String nom;

    @OneToMany(mappedBy = "role")
    private List<Utilisateur> utilisateurs;


    
    // Constructors
    public Role() {
    }

    public Role(String nom) {
        this.nom = nom;
    }

    // Getters and Setters
    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // toString method
    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", nom='" + nom +
                '}';
    }
}
