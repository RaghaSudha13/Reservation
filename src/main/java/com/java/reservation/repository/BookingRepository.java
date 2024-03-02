package com.java.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.reservation.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, String>{
    
}
