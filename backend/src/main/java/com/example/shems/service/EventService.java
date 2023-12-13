package com.example.shems.service;

import com.example.shems.model.Event;
import com.example.shems.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Integer id) {
        return eventRepository.findById(id);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> update(Integer id, Event eventDetails) {
        return eventRepository.findById(id)
                .map(event -> {
                    event.setDeviceId(eventDetails.getDeviceId());
                    event.setTimestamp(eventDetails.getTimestamp());
                    event.setEventType(eventDetails.getEventType());
                    event.setValue(eventDetails.getValue());
                    return eventRepository.save(event);
                });
    }

    public boolean deleteById(Integer id) {
        return eventRepository.findById(id)
                .map(event -> {
                    eventRepository.delete(event);
                    return true;
                }).orElse(false);
    }
}
