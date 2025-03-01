package com.superheros.ingrid.repository;

import com.superheros.ingrid.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
