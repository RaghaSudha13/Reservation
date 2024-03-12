package com.java.reservation.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AdminLoginDTO {
    private String mailId;
    private String password;
}
