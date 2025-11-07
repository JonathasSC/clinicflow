package com.clinicflow.services;

import com.clinicflow.dto.*;
import com.clinicflow.models.*;
import com.clinicflow.repositories.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClinicService {

    private final ClinicRepository clinicRepository;

    public ClinicResponseDTO registerClinic(ClinicRequestDTO dto) {
        if (clinicRepository.existsByTenantId(dto.getTenantId())) {
            throw new RuntimeException("Tenant ID já cadastrado: " + dto.getTenantId());
        }

        Address address = Address.builder()
                .street(dto.getAddress().getStreet())
                .number(dto.getAddress().getNumber())
                .neighborhood(dto.getAddress().getNeighborhood())
                .city(dto.getAddress().getCity())
                .state(dto.getAddress().getState())
                .zipCode(dto.getAddress().getZipCode())
                .build();

        Clinic clinic = Clinic.builder()
                .tenantId(dto.getTenantId())
                .name(dto.getName())
                .address(address)
                .build();

        Clinic saved = clinicRepository.save(clinic);

        return ClinicResponseDTO.builder()
                .id(saved.getId())
                .tenantId(saved.getTenantId())
                .name(saved.getName())
                .build();
    }
}
