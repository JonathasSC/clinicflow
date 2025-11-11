package com.clinicflow.repositories;

import java.util.UUID;

import com.clinicflow.models.business.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TenantRepository extends JpaRepository<Tenant, UUID> {
}