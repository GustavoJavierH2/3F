package com.superheros.ingrid.controllers;

import com.superheros.ingrid.entity.AttendeeEntity;
import com.superheros.ingrid.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/attendee")
public class AttendeeController {
    @Autowired
    private AttendeeService attendeeService;

    @PostMapping("/add")
    public ResponseEntity<AttendeeEntity> addEvent(@RequestBody AttendeeEntity attendee) {
        ResponseEntity<AttendeeEntity> respone;
        respone = attendeeService.addAttendee(attendee);
        return respone;
    }
    @GetMapping("/all")
    public ResponseEntity<List<AttendeeEntity>> getAllEvents() {
        ResponseEntity<List<AttendeeEntity>> respone;
        respone = attendeeService.getAllAttendees();
        return respone;
    }

}
