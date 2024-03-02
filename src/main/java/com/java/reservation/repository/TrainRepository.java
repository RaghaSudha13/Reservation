package com.java.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.reservation.model.Train;

public interface TrainRepository extends JpaRepository<Train, String>{
    
}
