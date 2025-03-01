package com.superheros.ingrid.services;

import com.superheros.ingrid.entity.AttendeeEntity;
import com.superheros.ingrid.entity.EventEntity;
import com.superheros.ingrid.repository.AttendeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendeeService {
    private AttendeeRepository attendeeRepository;

    public AttendeeService(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    public ResponseEntity<List<AttendeeEntity>> getAllAttendees() {
        try{
            List<AttendeeEntity> attendees = attendeeRepository.findAll();
            if(attendees.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(attendees);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }



    public ResponseEntity<AttendeeEntity> addAttendee(AttendeeEntity attendee) {
        try{
            attendeeRepository.save(attendee);
            if(attendee.getEmail()!= attendee.getEmail()){
                return ResponseEntity.status(HttpStatus.CREATED).body(attendee);
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
}
