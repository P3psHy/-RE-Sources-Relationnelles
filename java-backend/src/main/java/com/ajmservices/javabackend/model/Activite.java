package com.ajmservices.javabackend.model;

import jakarta.persistence.*;

@Entity
public class Activite extends TypeRessource {

    // Constructors
    public Activite() {
        super();
    }

    public Activite(String nom) {
        super(nom);
    }

}
