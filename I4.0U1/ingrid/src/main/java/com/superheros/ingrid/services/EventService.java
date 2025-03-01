package com.superheros.ingrid.services;

import com.superheros.ingrid.entity.AttendeeEntity;
import com.superheros.ingrid.entity.EventEntity;
import com.superheros.ingrid.repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public ResponseEntity<List<EventEntity>> getAllEvent() {
        try{
            List<EventEntity> event = eventRepository.findAll();
            if(event.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(event);
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }

    public ResponseEntity<EventEntity> getEventById(Long id) {
        try{
            Optional<EventEntity> event = eventRepository.findById(id);
            if(event.isPresent()){
                return ResponseEntity.ok(event.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
        return null;
    }

    public ResponseEntity<EventEntity> addEvent(EventEntity event) {
        try{
            eventRepository.save(event);
            return ResponseEntity.ok(event);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<EventEntity> updateEvent(EventEntity event, Long id) {
        try{
            Optional<EventEntity> event1= eventRepository.findById(id);
            if(event1.isPresent()){
                event.setId(id);
                event.setName(event.getName());
                event.setDescription(event.getDescription());
                event.setDate(event.getDate());
                event.setOrganizer(event.getOrganizer());
                eventRepository.save(event);
                return ResponseEntity.ok(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<EventEntity> deleteEvent(Long id) {
        try{
            Optional<EventEntity> event1= eventRepository.findById(id);
            if(event1.isPresent()){
                eventRepository.delete(event1.get());
                return ResponseEntity.ok(event1.get());
            }else {
                return ResponseEntity.noContent().build();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}
