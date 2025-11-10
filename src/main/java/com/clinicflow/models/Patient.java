package com.clinicflow.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patient")
@Data                       
@NoArgsConstructor          
@AllArgsConstructor          
@Builder              
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    @Column(unique = true)
    private String cpf;
}
