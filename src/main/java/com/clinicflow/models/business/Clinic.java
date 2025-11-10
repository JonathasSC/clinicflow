package com.clinicflow.models.business;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

import com.clinicflow.models.Address;

@Entity
@Table(name = "clinics")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, updatable = false, name = "tenant_id")
    private UUID tenantId;

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @PrePersist
    public void prePersist() {
        if (tenantId == null) {
            tenantId = UUID.randomUUID();
        }
    }
}
