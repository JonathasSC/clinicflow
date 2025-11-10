package com.clinicflow.dto.response;

import java.util.UUID;

import com.clinicflow.dto.AddressDTO;
import jakarta.validation.Valid;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicResponseDTO {
    private String name;

    private Long id;
    private UUID tenantId;

    @Valid 
    private AddressDTO address;
}
