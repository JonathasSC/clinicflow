package com.clinicflow.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicResponseDTO {
    private Long id;
    private String tenantId;
    private String name;
}
