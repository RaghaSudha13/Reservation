package com.java.reservation.service;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.reservation.dto.AdminRegisterDTO;
import com.java.reservation.exception.AdminRegistrationException;
import com.java.reservation.model.Admin;
import com.java.reservation.repository.AdminRepository;
import com.java.reservation.util.EmailUtil;
import com.java.reservation.util.OtpUtil;

@Service
public class AdminServiceImpl implements AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    private final AdminRepository adminRepository;
    private final OtpUtil otpUtil; // Declare as final
    private final EmailUtil emailUtil;

    @Autowired // Constructor injection
    public AdminServiceImpl(AdminRepository adminRepository, OtpUtil otpUtil, EmailUtil emailUtil) {
        this.adminRepository = adminRepository;
        this.otpUtil = otpUtil;
        this.emailUtil = emailUtil;
    }

    @Override
    public void registerAdmin(AdminRegisterDTO adminRegisterDTO) {
        logger.info("Attempting to register admin with mailId: {}", adminRegisterDTO.getMailId());
        if (adminRepository.existsByMailId(adminRegisterDTO.getMailId())) {
            throw new AdminRegistrationException("Email is already registered");
        }

        try {
            String otp = otpUtil.generateOtp();

            Admin admin = new Admin();
            admin.setMailId(adminRegisterDTO.getMailId());
            admin.setPassword(adminRegisterDTO.getPassword());
            admin.setOtp(otp);

            adminRepository.save(admin);
            emailUtil.sendOtpEmail(adminRegisterDTO.getMailId(), otp); // Send OTP email

            logger.info("Admin registered successfully");
        } catch (AdminRegistrationException e) {
            throw e; // Re-throw the exception to be handled in the controller
        } catch (Exception e) {
            logger.error("An error occurred while registering admin", e);
            throw new AdminRegistrationException("Failed to register admin. Please try again later.");
        }
    }

    @Override
public String verifyOtp(String mailId, String otp) {
    Admin admin = adminRepository.findByMailId(mailId);
    if (admin != null && admin.getOtp() != null && admin.getOtp().equals(otp)) {
        return "OTP Verified Successfully";
    } else {
        return "Invalid OTP";
    }
}

}
