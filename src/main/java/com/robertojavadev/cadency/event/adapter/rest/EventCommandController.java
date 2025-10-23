package com.robertojavadev.cadency.event.adapter.rest;

import com.robertojavadev.cadency.event.api.EventCreateDto;
import com.robertojavadev.cadency.event.api.EventDto;
import com.robertojavadev.cadency.event.api.EventFacade;
import com.robertojavadev.cadency.event.api.EventUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
class EventCommandController {

    private final EventFacade eventFacade;

    @PostMapping()
    public ResponseEntity<EventDto> createEvent(@RequestBody @Valid EventCreateDto eventCreateDto) {
        EventDto eventDto = eventFacade.createEvent(eventCreateDto);
        return new ResponseEntity<>(eventDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{eventId}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable UUID eventId,
                                                @RequestBody @Valid EventUpdateDto eventUpdateDto) {
        EventDto eventDto = eventFacade.updateEvent(eventId, eventUpdateDto);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<EventDto> deleteEvent(@PathVariable UUID eventId) {
        eventFacade.deleteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
