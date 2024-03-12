package com.java.reservation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.reservation.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

    boolean existsByMailId(String mailId);

    Admin findByMailId(String mailId);

    // Optional<Admin> findByMailId(String mailId);
    
}
