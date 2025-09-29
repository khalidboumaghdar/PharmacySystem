package com.aplication.pharmacysystem.Service;


import com.aplication.pharmacysystem.model.Fondateur;
import com.aplication.pharmacysystem.Repository.FondateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FondateurService {
    @Autowired
    private FondateurRepository fondateurRepository;

    public Fondateur create(Fondateur fondateur) {
        return fondateurRepository.save(fondateur);
    }

    public List<Fondateur> getAll() {
        return fondateurRepository.findAll();
    }

    public Optional<Fondateur> getById(Long id) {
        return fondateurRepository.findById(id);
    }

    public Fondateur update(Long id, Fondateur updated) {
        return fondateurRepository.findById(id).map(f -> {
            f.setUsername(updated.getUsername());
            f.setPassword(updated.getPassword());
            f.setEmail(updated.getEmail());
            return fondateurRepository.save(f);
        }).orElseThrow(() -> new RuntimeException("Fondateur not found"));
    }

    public void delete(Long id) {
        fondateurRepository.deleteById(id);
    }
}
