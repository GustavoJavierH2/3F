package com.superheros.ingrid.controllers;

import com.superheros.ingrid.entity.EventEntity;
import com.superheros.ingrid.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public ResponseEntity<List<EventEntity>> getAllEvents() {
        ResponseEntity<List<EventEntity>> respone;
        respone = eventService.getAllEvent();
        return respone;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EventEntity> getEventById(@PathVariable Long id) {
        ResponseEntity<EventEntity> respone;
        respone = eventService.getEventById(id);
        return respone;
    }

    @PostMapping("/add")
    public ResponseEntity<EventEntity> addEvent(@RequestBody EventEntity event) {
        ResponseEntity<EventEntity> respone;
        respone = eventService.addEvent(event);
        return respone;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EventEntity> updateEvent(@PathVariable Long id, @RequestBody EventEntity event) {
        ResponseEntity<EventEntity> respone;
        respone = eventService.updateEvent(event, id);
        return respone;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EventEntity> deleteEvent(@PathVariable Long id) {
        ResponseEntity<EventEntity> respone;
        respone = eventService.deleteEvent(id);
        return respone;
    }
}
