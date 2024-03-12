package com.java.reservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.reservation.dto.AdminLoginDTO;
import com.java.reservation.dto.AdminRegisterDTO;
import com.java.reservation.exception.AdminLoginException;
import com.java.reservation.exception.AdminRegistrationException;
import com.java.reservation.model.Train;
import com.java.reservation.service.AdminService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/r1")
@RestController
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @PostMapping("/adminRegistration")
    public ResponseEntity<String> registerAdmin(@RequestBody AdminRegisterDTO adminRegisterDTO) {
        try {
            logger.info("Attempting to register admin with mailId: {}", adminRegisterDTO.getMailId());
            adminService.registerAdmin(adminRegisterDTO);
            logger.info("Admin registered successfully");
            return ResponseEntity.ok("Admin Registered Successfully");
        } catch (AdminRegistrationException e) {
            logger.error("Error registering admin: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/verify-OTP")
    public ResponseEntity<String> verifyOtp(@RequestParam String mailId, @RequestParam String otp) {
        try {
            String message = adminService.verifyOtp(mailId, otp);
            return ResponseEntity.ok(message);
        } catch (AdminRegistrationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/adminLogin")
    public ResponseEntity<String> login(@RequestBody AdminLoginDTO adminLoginDTO){
        try{
          String loginStatus =  adminService.login(adminLoginDTO);
            return ResponseEntity.ok(loginStatus);
        }catch(AdminLoginException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("logout")
    public ResponseEntity<String> logout(HttpSession session){
        try{
          String status= adminService.logout(session);
            return ResponseEntity.ok(status);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PostMapping("adminLogout")
    public ResponseEntity<String> adminLogout(HttpSession session){
        try{
            session.invalidate();
            return ResponseEntity.ok("logeed out Successfully");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
