package com.example.demo.repository;

import com.example.demo.model.Faction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactionRepository extends JpaRepository<Faction, Long> {

    List<Faction> findByConflictId(Long conflictId);
}
