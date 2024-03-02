package com.java.reservation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AdminRegisterDTO {
    private String mailId;
    private String password;
    private String otp;
}
