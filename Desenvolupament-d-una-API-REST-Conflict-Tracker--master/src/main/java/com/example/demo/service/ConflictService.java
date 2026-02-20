package com.example.demo.service;

import com.example.demo.dto.ConflictDTO;
import com.example.demo.dto.CreateConflictDTO;
import com.example.demo.model.Status;

import java.util.List;

public interface ConflictService {

    List<ConflictDTO> findAll();

    List<ConflictDTO> findByStatus(Status status);

    ConflictDTO findById(Long id);

    ConflictDTO create(CreateConflictDTO dto);

    ConflictDTO update(Long id, CreateConflictDTO dto);

    void delete(Long id);

    List<ConflictDTO> findByCountryCode(String countryCode);
}
