package com.aplication.pharmacysystem.Repository;

import com.aplication.pharmacysystem.model.Fondateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FondateurRepository extends JpaRepository<Fondateur, Long> {
    Optional<Fondateur> findByEmail(String email);

}
