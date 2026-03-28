package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PatientMapper {
    public static PatientResponseDTO convertPatientToPatientDTO(Patient patient) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        patientResponseDTO.setId(String.valueOf(patient.getId()));
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setDateOfBirth(String.valueOf(patient.getDateOfBirth()));

        return patientResponseDTO;
    }

    public static Patient convertPatientDTOtoPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();

        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegistrationDate(LocalDate.parse(patientRequestDTO.getRegistrationDate()));

        return patient;
    }
}
