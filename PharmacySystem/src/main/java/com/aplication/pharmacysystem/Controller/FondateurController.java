package com.aplication.pharmacysystem.Controller;

import com.aplication.pharmacysystem.Service.FondateurService;
import com.aplication.pharmacysystem.DTO.FondateurDTO;
import com.aplication.pharmacysystem.DTO.FondateurCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fondateurs")
public class FondateurController {

    @Autowired
    private FondateurService fondateurService;

    @PostMapping
    public ResponseEntity<FondateurDTO> create(@RequestBody FondateurCreateDTO dto) {
        return ResponseEntity.ok(fondateurService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<FondateurDTO>> getAll() {
        return ResponseEntity.ok(fondateurService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FondateurDTO> getById(@PathVariable Long id) {
        return fondateurService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FondateurDTO> update(@PathVariable Long id, @RequestBody FondateurCreateDTO dto) {
        try {
            return ResponseEntity.ok(fondateurService.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fondateurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
