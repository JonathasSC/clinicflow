package com.clinicflow.repositories;

import com.clinicflow.models.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    boolean existsByTenantId(String tenantId);
}
