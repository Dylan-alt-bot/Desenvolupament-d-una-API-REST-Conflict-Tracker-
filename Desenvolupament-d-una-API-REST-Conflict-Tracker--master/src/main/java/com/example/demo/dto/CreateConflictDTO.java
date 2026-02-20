package com.example.demo.dto;

import com.example.demo.model.Status;
import java.time.LocalDate;
import java.util.Set;


public class CreateConflictDTO {
    private String name;
    private LocalDate startDate;
    private Status status;
    private String description;
    private Set<String> countryCodes;


    // getters/setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<String> getCountryCodes() { return countryCodes; }
    public void setCountryCodes(Set<String> countryCodes) { this.countryCodes = countryCodes; }
}
