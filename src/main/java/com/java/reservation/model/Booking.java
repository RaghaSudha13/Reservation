package com.java.reservation.model;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

//if we use serializable means it converting  the objects into byte stream
@Entity
@Data
public class Booking {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String mailId;
    private String trainNumber;
    private Date date;
    private String fromStation;
    private String toStation;
    private Integer seats;
    private Double amount;
}