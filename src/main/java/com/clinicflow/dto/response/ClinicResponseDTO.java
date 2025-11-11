package com.clinicflow.dto.response;

import com.clinicflow.dto.AddressDTO;
import jakarta.validation.Valid;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicResponseDTO {
    private String name;

    @Valid 
    private AddressDTO address;
}
