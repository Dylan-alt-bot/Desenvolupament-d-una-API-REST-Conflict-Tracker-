package com.example.demo.repository;

import com.example.demo.model.Conflict;
import com.example.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConflictRepository extends JpaRepository<Conflict, Long> {

    List<Conflict> findByStatus(Status status);

    @Query("""
        SELECT c
        FROM Conflict c
        JOIN c.countries country
        WHERE country.code = :code
    """)
    List<Conflict> findByCountryCode(@Param("code") String code);
}
