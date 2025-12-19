package com.example.demo.controller.rest;

import com.example.demo.dto.ConflictDTO;
import com.example.demo.dto.CreateConflictDTO;
import com.example.demo.model.Status;
import com.example.demo.service.ConflictService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conflicts")
public class ConflictController {

    private final ConflictService conflictService;

    public ConflictController(ConflictService conflictService) {
        this.conflictService = conflictService;
    }

    @GetMapping
    public ResponseEntity<List<ConflictDTO>> getAll(
            @RequestParam(value = "status", required = false) Status status) {
        if (status != null)
            return ResponseEntity.ok(conflictService.findByStatus(status));
        return ResponseEntity.ok(conflictService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(conflictService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ConflictDTO> create(@Valid @RequestBody CreateConflictDTO dto) {
        ConflictDTO created = conflictService.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConflictDTO> update(
            @PathVariable Long id, @Valid @RequestBody CreateConflictDTO dto) {
        return ResponseEntity.ok(conflictService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        conflictService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
