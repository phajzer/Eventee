package com.example.demo.web.controller;

import com.example.demo.service.EventService;
import com.example.demo.web.dto.EventRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public EventRecord getEvent(@PathVariable Long id) {
        return eventService.getEvent(id);
    }

    @PostMapping
    public EventRecord createEvent(@RequestBody EventRecord eventRecord){
        return eventService.addEvent(eventRecord);
    }

    @PatchMapping
    public EventRecord updateEvent(@RequestBody EventRecord eventRecord){
        return eventService.editEvent(eventRecord);
    }

}
