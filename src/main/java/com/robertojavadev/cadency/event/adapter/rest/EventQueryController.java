package com.robertojavadev.cadency.event.adapter.rest;

import com.robertojavadev.cadency.event.api.EventDto;
import com.robertojavadev.cadency.event.api.EventFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
class EventQueryController {

    private final EventFacade eventFacade;

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDto> findEventById(@PathVariable UUID eventId) {
        EventDto eventDto = eventFacade.findEventById(eventId);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Page<EventDto>> findAllEvents(Pageable pageable) {
        Page<EventDto> eventsDto = eventFacade.findAllEvents(pageable);
        return new ResponseEntity<>(eventsDto, HttpStatus.OK);
    }
}
