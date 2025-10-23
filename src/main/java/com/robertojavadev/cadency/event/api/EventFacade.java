package com.robertojavadev.cadency.event.api;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class EventFacade {
    public EventDto findEventById(UUID eventId) {
        return new EventDto();
    }

    public Page<EventDto> findAllEvents(Pageable pageable) {
        return new PageImpl<>(new ArrayList<EventDto>());
    }

    public EventDto createEvent(@Valid EventCreateDto eventCreateDto) {
        return new EventDto();
    }

    public EventDto updateEvent(UUID eventId, final @Valid EventUpdateDto eventUpdateDto) {
        return new EventDto();
    }

    public void deleteEvent(UUID eventId) {
    }
}
