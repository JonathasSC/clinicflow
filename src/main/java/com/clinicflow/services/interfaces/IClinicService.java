package com.clinicflow.services.interfaces;

import java.util.List;

import com.clinicflow.dto.request.ClinicRequestDTO;
import com.clinicflow.dto.response.ClinicResponseDTO;

public interface IClinicService {
    ClinicResponseDTO create(ClinicRequestDTO clinicDTO);
    List<ClinicResponseDTO> findAll ();
}
