package com.clinicflow.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
}
