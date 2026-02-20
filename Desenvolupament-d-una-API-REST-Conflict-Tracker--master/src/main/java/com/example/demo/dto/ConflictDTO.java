package com.example.demo.dto;

import com.example.demo.model.Status;
import java.time.LocalDate;
import java.util.List;


public class ConflictDTO {
    private Long id;
    private String name;
    private LocalDate startDate;
    private Status status;
    private String description;
    private List<CountryDTO> countryCodes; // només codi per simplificar la vista


    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<CountryDTO> getCountryCodes() { return countryCodes; }
    public void setCountryCodes(List<CountryDTO> countryCodes) { this.countryCodes = countryCodes; }

}
