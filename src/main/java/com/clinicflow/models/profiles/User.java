package com.clinicflow.models.profiles;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import org.hibernate.annotations.UuidGenerator;
import com.clinicflow.models.permissions.Role;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "tenant_id", nullable = false, updatable = false, unique = true)
    private UUID tenantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    @Column(nullable = false)
    private Boolean active = true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @Builder.Default
    private Set<Role> roles = new HashSet<>();

    @PrePersist
    public void prePersist() {
        if (tenantId == null) {
            tenantId = UUID.randomUUID();
        }
    }
}
