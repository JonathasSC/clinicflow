package com.clinicflow.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicflow.models.business.Clinic;


@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    // custom method
    boolean existsByTenantId(UUID tenantId);
}
