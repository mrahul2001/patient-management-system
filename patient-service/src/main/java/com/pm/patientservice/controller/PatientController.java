package com.pm.patientservice.controller;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validators.CreatePatientValidatorGroup;
import com.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@Tag(name = "Patient", description = "API for managing Patients")
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    @Operation(summary = "Get All Patients")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    @PostMapping("/create")
    @Operation(summary = "Create a Patient")
    public ResponseEntity<PatientResponseDTO> createPatient(@Validated({Default.class, CreatePatientValidatorGroup.class}) @RequestBody PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.createPatient(patientRequestDTO));
    }

    @PostMapping("/update/{id}")
    @Operation(summary = "Update a Patient's details")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.updatePatient(id, patientRequestDTO));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a Patient by its ID")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
