package com.aplication.pharmacysystem.Controller;


import com.aplication.pharmacysystem.model.Fondateur;
import com.aplication.pharmacysystem.Service.FondateurService;
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
    public Fondateur create(@RequestBody Fondateur fondateur) {
        return fondateurService.create(fondateur);
    }

    @GetMapping
    public List<Fondateur> getAll() {
        return fondateurService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fondateur> getById(@PathVariable Long id) {
        return fondateurService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fondateur> update(@PathVariable Long id, @RequestBody Fondateur fondateur) {
        try {
            return ResponseEntity.ok(fondateurService.update(id, fondateur));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fondateurService.delete(id);
    }
}

