package com.clinicflow.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantResponseDTO {
    private String name;
    private String domain;
}
