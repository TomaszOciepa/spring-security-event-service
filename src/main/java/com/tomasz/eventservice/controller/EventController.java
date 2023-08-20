package com.tomasz.eventservice.controller;

import com.tomasz.eventservice.model.Event;
import com.tomasz.eventservice.repository.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable String id){
        return eventRepository.findById(id).get();
    }

    @PostMapping("/event")
    public Event addEvent(@RequestBody Event event){
        return eventRepository.save(event);
    }
}
