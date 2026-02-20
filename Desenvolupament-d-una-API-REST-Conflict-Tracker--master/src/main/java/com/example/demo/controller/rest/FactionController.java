package com.example.demo.controller.rest;

import com.example.demo.model.Faction;
import com.example.demo.repository.FactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/factions")
public class FactionController {

    private final FactionRepository factionRepository;

    public FactionController(FactionRepository factionRepository) {
        this.factionRepository = factionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Faction>> getAll() {
        return ResponseEntity.ok(factionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faction> getById(@PathVariable Long id) {
        return factionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Faction> create(@RequestBody Faction faction) {
        Faction saved = factionRepository.save(faction);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faction> update(@PathVariable Long id, @RequestBody Faction faction) {
        return factionRepository.findById(id)
                .map(existing -> {
                    existing.setName(faction.getName());
                    existing.setConflict(faction.getConflict());
                    existing.setSupportingCountries(faction.getSupportingCountries());
                    return ResponseEntity.ok(factionRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        factionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
