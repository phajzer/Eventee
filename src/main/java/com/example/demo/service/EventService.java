package com.example.demo.service;

import com.example.demo.web.dto.EventRecord;

public interface EventService {

    EventRecord getEvent(Long id);
    EventRecord addEvent(EventRecord eventRecord);
    EventRecord editEvent(EventRecord eventRecord);
}
