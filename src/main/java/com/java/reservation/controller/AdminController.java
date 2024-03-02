package com.java.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.reservation.dto.AdminRegisterDTO;
import com.java.reservation.exception.AdminRegistrationException;
import com.java.reservation.service.AdminService;

@RequestMapping("/r1")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/adminRegistration")
    public ResponseEntity<String> registerAdmin(@RequestBody AdminRegisterDTO adminRegisterDTO) {
        try{
            adminService.registerAdmin(adminRegisterDTO);
            return ResponseEntity.ok("Admin Registered Successfully");
        }catch(AdminRegistrationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
