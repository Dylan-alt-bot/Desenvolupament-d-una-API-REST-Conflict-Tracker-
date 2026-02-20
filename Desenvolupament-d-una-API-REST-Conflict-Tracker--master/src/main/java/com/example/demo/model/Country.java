package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String code;


    @Column(nullable = false)
    private String name;


    @ManyToMany(mappedBy = "countries")
    private Set<Conflict> conflicts = new HashSet<>();


    @ManyToMany(mappedBy = "supportingCountries")
    private Set<Faction> supportedFactions = new HashSet<>();


    // constructors, getters, setters
    public Country() {}


    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }


    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<Conflict> getConflicts() { return conflicts; }
    public void setConflicts(Set<Conflict> conflicts) { this.conflicts = conflicts; }
    public Set<Faction> getSupportedFactions() { return supportedFactions; }
    public void setSupportedFactions(Set<Faction> supportedFactions) { this.supportedFactions = supportedFactions; }
}