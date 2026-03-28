package com.pm.patientservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pm.patientservice.dto.validators.CreatePatientValidatorGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequestDTO {

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Please enter a valid email")
    private String email;

    @NotBlank(message = "Address must not be empty")
    private String address;

    @NotBlank(message = "Date of Birth must not be null")
    private String dateOfBirth;

    @NotBlank(groups = CreatePatientValidatorGroup.class, message = "Date of Registration must not be null")
    private String registrationDate;
}
