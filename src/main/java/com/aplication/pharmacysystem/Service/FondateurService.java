package com.aplication.pharmacysystem.Service;

import com.aplication.pharmacysystem.DTO.AuthenticationRequest;
import com.aplication.pharmacysystem.DTO.AuthenticationResponse;
import com.aplication.pharmacysystem.DTO.FondateurDTO;
import com.aplication.pharmacysystem.DTO.FondateurCreateDTO;

import java.util.List;
import java.util.Optional;

public interface FondateurService {
    FondateurDTO create(FondateurCreateDTO dto);
    List<FondateurDTO> getAll();
    Optional<FondateurDTO> getById(Long id);
    FondateurDTO update(Long id, FondateurCreateDTO dto);
    void delete(Long id);
    AuthenticationResponse login(AuthenticationRequest request);

}
