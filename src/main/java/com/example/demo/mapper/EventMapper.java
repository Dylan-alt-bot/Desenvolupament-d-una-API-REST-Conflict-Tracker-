package com.example.demo.mapper;

import com.example.demo.dto.EventDTO;
import com.example.demo.model.Event;

public class EventMapper {

    private EventMapper() {
    }

    public static EventDTO toDTO(Event event) {
        if (event == null) return null;

        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setEventDate(event.getEventDate());
        dto.setLocation(event.getLocation());
        dto.setDescription(event.getDescription());
        dto.setConflictId(event.getConflict().getId());

        return dto;
    }
}
