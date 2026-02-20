package com.example.demo.mapper;

import com.example.demo.dto.ConflictDTO;
import com.example.demo.dto.CreateConflictDTO;
import com.example.demo.dto.CountryDTO;
import com.example.demo.model.Conflict;
import com.example.demo.model.Country;

import java.util.List;
import java.util.stream.Collectors;

public class ConflictMapper {

    private ConflictMapper() {
    }

    public static ConflictDTO toDTO(Conflict conflict) {
        if (conflict == null) return null;

        ConflictDTO dto = new ConflictDTO();
        dto.setId(conflict.getId());
        dto.setName(conflict.getName());
        dto.setStartDate(conflict.getStartDate());
        dto.setStatus(conflict.getStatus());
        dto.setDescription(conflict.getDescription());

        List<CountryDTO> countries = conflict.getCountries()
                .stream()
                .map(ConflictMapper::toCountryDTO)
                .collect(Collectors.toList());

        dto.setCountryCodes(countries);
        return dto;
    }

    public static Conflict fromCreateDTO(CreateConflictDTO dto) {
        if (dto == null) return null;

        Conflict conflict = new Conflict();
        conflict.setName(dto.getName());
        conflict.setStartDate(dto.getStartDate());
        conflict.setStatus(dto.getStatus());
        conflict.setDescription(dto.getDescription());
        return conflict;
    }

    private static CountryDTO toCountryDTO(Country country) {
        CountryDTO dto = new CountryDTO();
        dto.setId(country.getId());
        dto.setName(country.getName());
        dto.setCode(country.getCode());
        return dto;
    }
}
