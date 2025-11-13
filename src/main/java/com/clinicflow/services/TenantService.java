package com.clinicflow.services;

import com.clinicflow.dto.request.TenantRequestDTO;
import com.clinicflow.dto.response.TenantResponseDTO;
import com.clinicflow.models.business.Tenant;
import com.clinicflow.repositories.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class TenantService extends BaseService<Tenant, UUID, TenantRequestDTO, TenantResponseDTO> {

    public TenantService(TenantRepository repository) {
        super(repository);
    }

    @Override
    public TenantResponseDTO create(TenantRequestDTO request) {
        Tenant tenant = toEntity(request);
        return toResponse(repository.save(tenant));
    }

    @Override
    public TenantResponseDTO update(UUID id, TenantRequestDTO request) {
        Tenant tenant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));
        tenant.setName(request.getName());
        return toResponse(repository.save(tenant));
    }

    @Override
    protected Tenant toEntity(TenantRequestDTO request) {
        return new Tenant(request.getName(), request.getDomain());
    }

    @Override
    protected TenantResponseDTO toResponse(Tenant entity) {
        return new TenantResponseDTO(entity.getName(), entity.getDomain());
    }
}
