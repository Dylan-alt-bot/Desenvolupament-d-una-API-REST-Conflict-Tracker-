package com.example.demo.dto;

import java.util.List;

public class CreateFactionDTO {

    private String name;

    private Long conflictId;

    private List<Long> supportingCountryIds;

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

    public List<Long> getSupportingCountryIds() {
        return supportingCountryIds;
    }

    public void setSupportingCountryIds(List<Long> supportingCountryIds) {
        this.supportingCountryIds = supportingCountryIds;
    }
}
