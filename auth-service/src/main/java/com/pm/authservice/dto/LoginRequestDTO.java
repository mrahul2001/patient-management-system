package com.pm.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank(message = "Please enter email")
    @Email(message = "Please enter valid email ID")
    private String email;

    @NotBlank(message = "Please enter Password")
    @Size(min = 8, message = "Password should be atleast 8 characters long")
    private String password;
}
