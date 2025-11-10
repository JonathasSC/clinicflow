package com.clinicflow.dto.request;

import java.util.UUID;

import jakarta.validation.Valid;
import lombok.*;

import com.clinicflow.dto.AddressDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicRequestDTO {
    private Long id;
    private UUID tenantId;
    private String name;

    @Valid 
    private AddressDTO address;
}
