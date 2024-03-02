package com.java.reservation.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Train {
    @Id
    @Column(name ="id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id; 
    private String trainNumber;
    private String trainName;
    private String fromStation;
    private String toStation;
    private Integer seats;
    private Double fare;
}
