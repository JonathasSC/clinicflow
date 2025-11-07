package com.clinicflow.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicRequestDTO {
    private String tenantId;
    private String name;
    private AddressDTO address;
}
