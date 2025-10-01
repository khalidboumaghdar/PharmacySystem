package com.aplication.pharmacysystem.Service;

import com.aplication.pharmacysystem.model.Fondateur;
import com.aplication.pharmacysystem.Repository.FondateurRepository;
import com.aplication.pharmacysystem.DTO.FondateurDTO;
import com.aplication.pharmacysystem.DTO.FondateurCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FondateurServiceImpl implements FondateurService {

    @Autowired
    private FondateurRepository fondateurRepository;

    @Override
    public FondateurDTO create(FondateurCreateDTO dto) {
        Fondateur f = new Fondateur();
        f.setUsername(dto.getUsername());
        f.setEmail(dto.getEmail());
        f.setPassword(dto.getPassword());
        Fondateur saved = fondateurRepository.save(f);
        return convertToDTO(saved);
    }

    @Override
    public List<FondateurDTO> getAll() {
        return fondateurRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FondateurDTO> getById(Long id) {
        return fondateurRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public FondateurDTO update(Long id, FondateurCreateDTO dto) {
        return fondateurRepository.findById(id).map(f -> {
            f.setUsername(dto.getUsername());
            f.setEmail(dto.getEmail());
            f.setPassword(dto.getPassword());
            return convertToDTO(fondateurRepository.save(f));
        }).orElseThrow(() -> new RuntimeException("Fondateur not found"));
    }

    @Override
    public void delete(Long id) {
        fondateurRepository.deleteById(id);
    }

    private FondateurDTO convertToDTO(Fondateur f) {
        return new FondateurDTO(f.getUsername(), f.getEmail());
    }
}
