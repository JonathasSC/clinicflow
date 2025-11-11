package com.clinicflow.models.business;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "tenants")
@Data                       
@NoArgsConstructor          
@AllArgsConstructor          
@Builder  
public class Tenant {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;
    
    @Column
    private String name;


    @Column
    private String domain;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Tenant(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }
}
