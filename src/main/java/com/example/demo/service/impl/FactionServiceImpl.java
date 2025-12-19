package com.example.demo.service.impl;

import com.example.demo.dto.CreateFactionDTO;
import com.example.demo.dto.FactionDTO;
import com.example.demo.model.Conflict;
import com.example.demo.model.Country;
import com.example.demo.model.Faction;
import com.example.demo.mapper.FactionMapper;
import com.example.demo.repository.ConflictRepository;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.FactionRepository;
import com.example.demo.service.FactionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FactionServiceImpl implements FactionService {

    private final FactionRepository factionRepository;
    private final ConflictRepository conflictRepository;
    private final CountryRepository countryRepository;

    public FactionServiceImpl(FactionRepository factionRepository,
                              ConflictRepository conflictRepository,
                              CountryRepository countryRepository) {
        this.factionRepository = factionRepository;
        this.conflictRepository = conflictRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<FactionDTO> findAll() {
        return factionRepository.findAll()
                .stream()
                .map(FactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FactionDTO findById(Long id) {
        Faction faction = factionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faction not found"));
        return FactionMapper.toDTO(faction);
    }

    @Override
    public List<FactionDTO> findByConflict(Long conflictId) {
        return factionRepository.findByConflictId(conflictId)
                .stream()
                .map(FactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FactionDTO create(CreateFactionDTO dto) {
        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        Faction faction = new Faction();
        faction.setName(dto.getName());
        faction.setConflict(conflict);

        if (dto.getSupportingCountryIds() != null) {
            dto.getSupportingCountryIds().forEach(countryId -> {
                Country country = countryRepository.findById(countryId)
                        .orElseThrow(() -> new RuntimeException("Country not found"));
                faction.getSupportingCountries().add(country);
            });
        }

        return FactionMapper.toDTO(factionRepository.save(faction));
    }

    @Override
    public FactionDTO update(Long id, CreateFactionDTO dto) {
        Faction faction = factionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faction not found"));

        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        faction.setName(dto.getName());
        faction.setConflict(conflict);
        faction.getSupportingCountries().clear();

        if (dto.getSupportingCountryIds() != null) {
            dto.getSupportingCountryIds().forEach(countryId -> {
                Country country = countryRepository.findById(countryId)
                        .orElseThrow(() -> new RuntimeException("Country not found"));
                faction.getSupportingCountries().add(country);
            });
        }

        return FactionMapper.toDTO(factionRepository.save(faction));
    }

    @Override
    public void delete(Long id) {
        factionRepository.deleteById(id);
    }
}
