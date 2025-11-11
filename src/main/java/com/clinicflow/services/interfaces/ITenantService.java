package com.clinicflow.services.interfaces;

import java.util.UUID;

import com.clinicflow.dto.request.TenantRequestDTO;
import com.clinicflow.dto.response.TenantResponseDTO;

public interface ITenantService {
    TenantResponseDTO create(TenantRequestDTO request);
    TenantResponseDTO findAll(TenantRequestDTO tenantDTO);
    TenantResponseDTO findById(UUID id);
    TenantResponseDTO update(TenantRequestDTO tenantDTO);
    void delete(UUID id);
}
