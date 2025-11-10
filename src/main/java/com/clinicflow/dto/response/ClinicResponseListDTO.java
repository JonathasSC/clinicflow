package com.clinicflow.dto.response;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClinicResponseListDTO {
    private List<ClinicResponseDTO> clinics;
}
