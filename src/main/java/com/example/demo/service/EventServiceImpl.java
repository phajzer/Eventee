package com.example.demo.service;

import com.example.demo.repo.Event;
import com.example.demo.repo.EventRepository;
import com.example.demo.web.dto.EventRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.demo.utils.EventMapper.*;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;

    @Override
    public EventRecord getEvent(Long id) {
        Event event = eventRepository.getReferenceById(id);
        return eventToEventRecord(event);
    }

    @Override
    public EventRecord addEvent(EventRecord eventRecord) {
        return eventToEventRecord(eventRepository.save(eventRecordToEvent(eventRecord)));
    }

    @Override
    public EventRecord editEvent(EventRecord eventRecord) {
        Event updateEvent = eventRecordToEvent(eventRecord);
        Event loadedEvent = eventRepository.getReferenceById(updateEvent.getId());
        if (!loadedEvent.equals(updateEvent)) {
            eventRepository.save(updateEvent);
        }
        return eventRecord;
    }
}
