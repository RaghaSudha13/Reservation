package com.java.reservation.service;

import org.springframework.stereotype.Service;

import com.java.reservation.dto.AdminLoginDTO;
import com.java.reservation.dto.AdminRegisterDTO;

import jakarta.servlet.http.HttpSession;
@Service
public interface AdminService {

    void registerAdmin(AdminRegisterDTO adminRegisterDTO);

    String verifyOtp(String mailId, String otp);

    String login(AdminLoginDTO adminLoginDTO);
    
    String logout(HttpSession session);
}
