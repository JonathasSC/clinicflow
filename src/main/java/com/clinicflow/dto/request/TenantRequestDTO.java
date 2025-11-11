package com.clinicflow.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantRequestDTO {
    private String name;
    private String domain;
}
