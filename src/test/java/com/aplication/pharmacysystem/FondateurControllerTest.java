package com.aplication.pharmacysystem;

import com.aplication.pharmacysystem.DTO.FondateurCreateDTO;
import com.aplication.pharmacysystem.DTO.FondateurDTO;
import com.aplication.pharmacysystem.Service.FondateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FondateurControllerTest {

    @Autowired
    private FondateurService fondateurService;

    @Test
    void testCreateFondateur() {
        FondateurCreateDTO createDTO = new FondateurCreateDTO();
        createDTO.setUsername("khalid");
        createDTO.setEmail("khalid@example.com");

        FondateurDTO result = fondateurService.create(createDTO);

        assertNotNull(result);
        assertEquals("khalid", result.getUsername());
        assertEquals("khalid@example.com", result.getEmail());
    }
}
