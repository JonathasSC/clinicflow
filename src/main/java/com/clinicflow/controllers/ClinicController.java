package com.clinicflow.controllers;

import com.clinicflow.dto.*;
import com.clinicflow.services.ClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinics")
@RequiredArgsConstructor
public class ClinicController {

    private final ClinicService clinicService;

    @PostMapping
    public ResponseEntity<ClinicResponseDTO> register(@RequestBody ClinicRequestDTO clinicDto) {
        ClinicResponseDTO response = clinicService.registerClinic(clinicDto);
        return ResponseEntity.ok(response);
    }
}
