package com.java.reservation.service;

import org.springframework.stereotype.Service;

import com.java.reservation.dto.AdminRegisterDTO;
@Service
public interface AdminService {

    void registerAdmin(AdminRegisterDTO adminRegisterDTO);

    String verifyOtp(String mailId, String otp);
    
}
