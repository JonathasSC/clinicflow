package com.clinicflow.dto.response;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponseDTO {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;

    @NotNull(message = "O CEP é obrigátorio")
    @NotBlank(message = "O CEP é obrigatório")
    private String zipCode;
}
