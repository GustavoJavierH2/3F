package com.superheros.ingrid.repository;

import com.superheros.ingrid.entity.EventEntity;
import com.superheros.ingrid.entity.OrganizerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizerRepository extends JpaRepository<OrganizerEntity, Long> {
    Optional<EventEntity> findByName(String name);
    //Optional<OrganizerEntity> findByOrganizerName(String organizerName);
}
