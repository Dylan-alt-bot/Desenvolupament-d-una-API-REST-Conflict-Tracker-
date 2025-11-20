package com.example.demo.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "conflicts")

public class Conflict {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private LocalDate startDate;
    @Enumerated(EnumType.STRING)
    @Column
    private Status status;
    @Lob
    private String description;

    @ManyToMany(
            mappedBy = "conflict",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    Country country;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
