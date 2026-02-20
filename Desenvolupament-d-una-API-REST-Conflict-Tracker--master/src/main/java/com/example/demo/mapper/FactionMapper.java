package com.example.demo.mapper;

import com.example.demo.dto.CountryDTO;
import com.example.demo.dto.FactionDTO;
import com.example.demo.model.Faction;

import java.util.List;
import java.util.stream.Collectors;

public class FactionMapper {

    private FactionMapper() {
    }

    public static FactionDTO toDTO(Faction faction) {
        if (faction == null) return null;

        FactionDTO dto = new FactionDTO();
        dto.setId(faction.getId());
        dto.setName(faction.getName());
        dto.setConflictId(faction.getConflict().getId());

        List<CountryDTO> supportingCountries = faction.getSupportingCountries()
                .stream()
                .map(country -> {
                    CountryDTO c = new CountryDTO();
                    c.setId(country.getId());
                    c.setName(country.getName());
                    c.setCode(country.getCode());
                    return c;
                })
                .collect(Collectors.toList());

        dto.setSupportingCountries(supportingCountries);
        return dto;
    }
}
