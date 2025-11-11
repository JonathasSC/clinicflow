package com.clinicflow.services;

import com.clinicflow.dto.AddressDTO;
import com.clinicflow.dto.request.ClinicRequestDTO;
import com.clinicflow.dto.response.ClinicResponseDTO;
import com.clinicflow.models.Address;
import com.clinicflow.models.business.Clinic;
import com.clinicflow.repositories.ClinicRepository;
import com.clinicflow.services.interfaces.IClinicService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClinicService implements IClinicService {
    private final ClinicRepository clinicRepository;

    @Override
    public ClinicResponseDTO create(ClinicRequestDTO dto) {

        UUID tenantId = dto.getTenantId();

        if (tenantId == null) {
            tenantId = UUID.randomUUID();
        }

        if (clinicRepository.existsByTenantId(tenantId)) {
            throw new RuntimeException("Tenant ID já cadastrado: " + tenantId);
        }


        Address address = buildAddressFromDTO(dto.getAddress());


        Clinic clinic = Clinic.builder()
                .name(dto.getName())
                .address(address)
                .build();

        Clinic saved = clinicRepository.save(clinic);
        return buildClinicResponseDTO(saved);
    }

    @Override
    public List<ClinicResponseDTO> findAll() {
        return clinicRepository.findAll().stream()
                .map(this::buildClinicResponseDTO)
                .toList();
    }

    private Address buildAddressFromDTO(AddressDTO dto) {
        return Address.builder()
                .street(dto.getStreet())
                .number(dto.getNumber())
                .neighborhood(dto.getNeighborhood())
                .city(dto.getCity())
                .state(dto.getState())
                .zipCode(dto.getZipCode())
                .build();
    }

    private ClinicResponseDTO buildClinicResponseDTO(Clinic clinic) {
        Address address = clinic.getAddress();

        return ClinicResponseDTO.builder()
                .name(clinic.getName())
                .address(AddressDTO.builder()
                        .street(address.getStreet())
                        .number(address.getNumber())
                        .neighborhood(address.getNeighborhood())
                        .city(address.getCity())
                        .state(address.getState())
                        .zipCode(address.getZipCode())
                        .build())
                .build();
    }
}
