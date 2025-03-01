package com.superheros.ingrid.controllers;

import com.superheros.ingrid.entity.EventEntity;
import com.superheros.ingrid.entity.OrganizerEntity;
import com.superheros.ingrid.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {
    @Autowired
    private OrganizerService organizerService;

    @PostMapping("/add")
    public ResponseEntity<OrganizerEntity> addEvent(@RequestBody OrganizerEntity organizer) {
        ResponseEntity<OrganizerEntity> respone;
        respone = organizerService.addOrganizer(organizer);
        return respone;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<EventEntity> getAllEvents(@PathVariable String nombre) {
        ResponseEntity<EventEntity> respone;
        respone = organizerService.getEventByName(nombre);
        return respone;
    }
}
