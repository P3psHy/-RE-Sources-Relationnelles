package com.ajmservices.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    private String typeRole;

    // Constructors
    public Role() {
    }

    public Role(String typeRole) {
        this.typeRole = typeRole;
    }

    // Getters and Setters
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(String typeRole) {
        this.typeRole = typeRole;
    }

    // toString method
    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", typeRole='" + typeRole + '\'' +
                '}';
    }
}

