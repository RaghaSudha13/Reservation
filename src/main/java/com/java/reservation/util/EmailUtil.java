package com.java.reservation.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component

public class EmailUtil {
    private final JavaMailSender emailSender;

    public EmailUtil(JavaMailSender emailSender){
        this.emailSender = emailSender;
    }

    public void sendOtpEmail(String to, String otp) {
        // MimeMessage is used to send the email
        MimeMessage message = emailSender.createMimeMessage();
        // MimeMessageHelper is used to set email properties like recipients, subject, body
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            // Extract name from email from 0 index to @
            String name = to.substring(0, to.indexOf("@"));
            String[] nameParts = name.split("\\.");
            String firstName = nameParts[0];
            String lastName = nameParts.length > 1 ? nameParts[1] : "";

            // Compose email body
            String subject = "OTP for Admin Registration";
            String body = "Hi " + firstName + " " + lastName + ",\n\n"
                    + "This is to inform you that you have registered successfully.\n\n"
                    + "Here is your OTP to verify your email:\n"
                    + otp + "\n\n"
                    + "Regards,\n"
                    + "Indian Railways.";

            // Set email properties
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);

            // Send email
            emailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send OTP email. Please try again.");
        }
    }
}
