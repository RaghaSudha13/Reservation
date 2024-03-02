package com.java.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.reservation.model.User;

public interface UserRepository extends JpaRepository<User, String>{
    
}
