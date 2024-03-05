package com.ajmservices.javabackend.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Datetime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date date;

    // Constructors
    public Datetime() {
    }

    // Getters and Setters
    public Date getDate() {
        return date;
    }

    // toString method
    @Override
    public String toString() {
        return "Datetime{" +
                "date=" + date +
                '}';
    }
}
