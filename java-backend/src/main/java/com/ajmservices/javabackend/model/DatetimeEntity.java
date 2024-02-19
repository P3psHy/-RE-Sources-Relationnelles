package com.ajmservices.javabackend.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
public class DatetimeEntity {
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(mappedBy = "date")
    private Set<RedigerMessage> messagesALaDate;

    // Constructors
    public DatetimeEntity() {
    }

    public DatetimeEntity(Date date) {
        this.date = date;
    }

    // Getters and Setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // toString method
    @Override
    public String toString() {
        return "DatetimeEntity{" +
                "date=" + date +
                '}';
    }
}

