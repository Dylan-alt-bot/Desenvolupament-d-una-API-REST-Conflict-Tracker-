package com.example.demo.service.impl;

import com.example.demo.dto.ConflictDTO;
import com.example.demo.dto.CreateConflictDTO;
import com.example.demo.model.Conflict;
import com.example.demo.model.Status;
import com.example.demo.model.Country;
import com.example.demo.mapper.ConflictMapper;
import com.example.demo.repository.ConflictRepository;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.ConflictService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConflictServiceImpl implements ConflictService {

    private final ConflictRepository conflictRepository;
    private final CountryRepository countryRepository;

    public ConflictServiceImpl(ConflictRepository conflictRepository,
                               CountryRepository countryRepository) {
        this.conflictRepository = conflictRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<ConflictDTO> findAll() {
        return conflictRepository.findAll()
                .stream()
                .map(ConflictMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConflictDTO> findByStatus(Status status) {
        return conflictRepository.findByStatus(status)
                .stream()
                .map(ConflictMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ConflictDTO findById(Long id) {
        Conflict conflict = conflictRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
        return ConflictMapper.toDTO(conflict);
    }

    @Override
    public ConflictDTO create(CreateConflictDTO dto) {
        Conflict conflict = ConflictMapper.fromCreateDTO(dto);

        if (dto.getCountryCodes() != null) {
            dto.getCountryCodes().forEach(countryId -> {
                Country country = countryRepository.findById(Long.valueOf(countryId))
                        .orElseThrow(() -> new RuntimeException("Country not found"));
                conflict.getCountries().add(country);
            });
        }

        return ConflictMapper.toDTO(conflictRepository.save(conflict));
    }

    @Override
    public ConflictDTO update(Long id, CreateConflictDTO dto) {
        Conflict conflict = conflictRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        conflict.setName(dto.getName());
        conflict.setStartDate(dto.getStartDate());
        conflict.setStatus(dto.getStatus());
        conflict.setDescription(dto.getDescription());
        conflict.getCountries().clear();

        if (dto.getCountryCodes() != null) {
            dto.getCountryCodes().forEach(countryId -> {
                Country country = countryRepository.findById(Long.valueOf(countryId))
                        .orElseThrow(() -> new RuntimeException("Country not found"));
                conflict.getCountries().add(country);
            });
        }

        return ConflictMapper.toDTO(conflictRepository.save(conflict));
    }

    @Override
    public void delete(Long id) {
        conflictRepository.deleteById(id);
    }

    @Override
    public List<ConflictDTO> findByCountryCode(String countryCode) {
        return conflictRepository.findByCountryCode(countryCode)
                .stream()
                .map(ConflictMapper::toDTO)
                .collect(Collectors.toList());
    }
}
