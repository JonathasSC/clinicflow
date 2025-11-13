package com.clinicflow.controllers;

import com.clinicflow.dto.request.ClinicRequestDTO;
import com.clinicflow.dto.response.ClinicResponseDTO;
import com.clinicflow.dto.response.ClinicResponseListDTO;
import com.clinicflow.models.business.Clinic;
import com.clinicflow.services.BaseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clinic")
@RequiredArgsConstructor
@Validated
public class ClinicController {

    private final BaseService<Clinic, UUID, ClinicRequestDTO, ClinicResponseDTO> clinicService;

    @PostMapping
    public ResponseEntity<ClinicResponseDTO> register(@Valid @RequestBody ClinicRequestDTO clinicDto) {
        ClinicResponseDTO response = clinicService.create(clinicDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ClinicResponseListDTO> getAllClinics() {
        List<ClinicResponseDTO> clinics = clinicService.findAll();
        return ResponseEntity.ok(
                ClinicResponseListDTO.builder()
                        .clinics(clinics)
                        .build()
        );
    }
}
