package com.aplication.pharmacysystem.Service;

import com.aplication.pharmacysystem.Repository.FondateurRepository;
import com.aplication.pharmacysystem.model.Fondateur;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final FondateurRepository fondateurRepository;

    public CustomUserDetailsService(FondateurRepository fondateurRepository) {
        this.fondateurRepository = fondateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Fondateur fondateur = fondateurRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        return org.springframework.security.core.userdetails.User
                .withUsername(fondateur.getEmail())
                .password(fondateur.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }

}
