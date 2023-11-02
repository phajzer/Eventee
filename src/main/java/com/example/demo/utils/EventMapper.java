package com.example.demo.utils;

import com.example.demo.repo.Event;
import com.example.demo.web.dto.EventRecord;

public class EventMapper {
    public static EventRecord eventToEventRecord(Event event) {
        return new EventRecord(event.getId(), event.getName(), event.getStartTime(), event.getEndTime(), event.getDescription());
    }

    public static Event eventRecordToEvent(EventRecord eventRecord) {
    return Event.builder()
            .id(eventRecord.id())
            .name(eventRecord.name())
            .startTime(eventRecord.startTime())
            .endTime(eventRecord.endTime())
            .description(eventRecord.description())
            .build();
    }
}
