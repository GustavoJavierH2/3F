package com.superheros.ingrid.repository;

import com.superheros.ingrid.entity.AttendeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttendeeRepository extends JpaRepository<AttendeeEntity, Long> {
    Optional<AttendeeEntity> findByEmail();
}
