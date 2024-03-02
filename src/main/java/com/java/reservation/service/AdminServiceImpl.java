package com.java.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.reservation.dto.AdminRegisterDTO;
import com.java.reservation.exception.AdminRegistrationException;
import com.java.reservation.model.Admin;
import com.java.reservation.repository.AdminRepository;
import com.java.reservation.util.OtpUtil;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    private AdminRegisterDTO adminRegisterDTO;

    private OtpUtil otpUtil;

    @Override
    public void registerAdmin(AdminRegisterDTO adminRegisterDTO) {
        if (adminRepository.existsByMailId(adminRegisterDTO.getMailId())) {
            throw new AdminRegistrationException("Email is already register");
        }

        String otp =otpUtil.generateOtp();

        Admin admin = new Admin();
        admin.setMailId(adminRegisterDTO.getMailId());
        admin.setPassword(adminRegisterDTO.getPassword());

        adminRepository.save(admin);

   
    }

}
