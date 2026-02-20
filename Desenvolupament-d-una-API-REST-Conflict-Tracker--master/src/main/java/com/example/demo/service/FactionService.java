package com.example.demo.service;

import com.example.demo.dto.CreateFactionDTO;
import com.example.demo.dto.FactionDTO;

import java.util.List;

public interface FactionService {

    List<FactionDTO> findAll();

    FactionDTO findById(Long id);

    List<FactionDTO> findByConflict(Long conflictId);

    FactionDTO create(CreateFactionDTO dto);

    FactionDTO update(Long id, CreateFactionDTO dto);

    void delete(Long id);
}