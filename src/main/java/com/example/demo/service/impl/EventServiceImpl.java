package com.example.demo.service.impl;

import com.example.demo.dto.CreateEventDTO;
import com.example.demo.dto.EventDTO;
import com.example.demo.model.Conflict;
import com.example.demo.model.Event;
import com.example.demo.mapper.EventMapper;
import com.example.demo.repository.ConflictRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ConflictRepository conflictRepository;

    public EventServiceImpl(EventRepository eventRepository,
                            ConflictRepository conflictRepository) {
        this.eventRepository = eventRepository;
        this.conflictRepository = conflictRepository;
    }

    @Override
    public List<EventDTO> findAll() {
        return eventRepository.findAll()
                .stream()
                .map(EventMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO findById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return EventMapper.toDTO(event);
    }

    @Override
    public List<EventDTO> findByConflict(Long conflictId) {
        return eventRepository.findByConflictId(conflictId)
                .stream()
                .map(EventMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO create(CreateEventDTO dto) {
        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        Event event = new Event();
        event.setEventDate(dto.getEventDate());
        event.setLocation(dto.getLocation());
        event.setDescription(dto.getDescription());
        event.setConflict(conflict);

        return EventMapper.toDTO(eventRepository.save(event));
    }

    @Override
    public EventDTO update(Long id, CreateEventDTO dto) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        event.setEventDate(dto.getEventDate());
        event.setLocation(dto.getLocation());
        event.setDescription(dto.getDescription());
        event.setConflict(conflict);

        return EventMapper.toDTO(eventRepository.save(event));
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
