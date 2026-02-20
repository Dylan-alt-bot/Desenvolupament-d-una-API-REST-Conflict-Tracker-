package com.example.demo.service;

import com.example.demo.dto.CreateEventDTO;
import com.example.demo.dto.EventDTO;

import java.util.List;

public interface EventService {

    List<EventDTO> findAll();

    EventDTO findById(Long id);

    List<EventDTO> findByConflict(Long conflictId);

    EventDTO create(CreateEventDTO dto);

    EventDTO update(Long id, CreateEventDTO dto);

    void delete(Long id);
}
