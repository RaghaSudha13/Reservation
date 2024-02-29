package com.java.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.reservation.entity.Train;

public interface TrainRepository extends JpaRepository<Train, String>{
    
}
