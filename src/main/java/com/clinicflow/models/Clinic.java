package com.clinicflow.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;



@Entity
@Table(name = "clinics")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, unique = true)
    private Long id;
  
    @Builder.Default
    @Column(nullable = false, updatable = false)
    private UUID tenantId = UUID.randomUUID();

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
