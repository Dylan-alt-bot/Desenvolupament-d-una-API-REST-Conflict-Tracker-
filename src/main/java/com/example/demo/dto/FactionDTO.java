package com.example.demo.dto;

import java.util.List;

public class FactionDTO {

    private Long id;
    private String name;
    private Long conflictId;
    private List<CountryDTO> supportingCountries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getConflictId() {
        return conflictId;
    }

    public void setConflictId(Long conflictId) {
        this.conflictId = conflictId;
    }

    public List<CountryDTO> getSupportingCountries() {
        return supportingCountries;
    }

    public void setSupportingCountries(List<CountryDTO> supportingCountries) {
        this.supportingCountries = supportingCountries;
    }
}
