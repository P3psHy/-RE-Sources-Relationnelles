package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;

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
        return id_role;
    }

    public void setIdRole(Long id_role) {
        this.id_role = id_role;
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
                "id_role=" + id_role +
                ", nom='" + nom +
                '}';
    }
}
