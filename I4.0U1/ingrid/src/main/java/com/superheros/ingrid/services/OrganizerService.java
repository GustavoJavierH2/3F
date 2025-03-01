package com.superheros.ingrid.services;

import com.superheros.ingrid.entity.EventEntity;
import com.superheros.ingrid.entity.OrganizerEntity;
import com.superheros.ingrid.repository.OrganizerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizerService {
    private OrganizerRepository organizerRepository;
    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public ResponseEntity<OrganizerEntity> addOrganizer(OrganizerEntity organizer) {
        try{
            organizerRepository.save(organizer);
            return ResponseEntity.status(HttpStatus.CREATED).body(organizer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(organizer);
        }
    }

    public ResponseEntity<EventEntity> getEventByName(String name) {
        try{
            Optional<EventEntity> event = organizerRepository.findByName(name);
            if(event.isPresent()){
                return ResponseEntity.ok(event.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
        return null;
    }

}
