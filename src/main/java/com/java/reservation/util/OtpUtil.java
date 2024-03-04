package com.java.reservation.util;

import java.util.UUID;
// import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class OtpUtil {
    public String generateOtp() {
        String otp = UUID.randomUUID().toString().replace("-","");
        return otp.substring(otp.length() -4);
    }

}


    // private static final int OTP_Length = 4;

    // public static String generateOtp() {
    // StringBuilder otp = new StringBuilder();
    // Random random = new Random();
    // for (int i = 0; i < OTP_Length; i++) {
    // otp.append(random.nextInt(10));
    // }
    // return otp.toString();

    // }
