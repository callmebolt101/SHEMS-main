package com.example.shems.repository;

import com.example.shems.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    // Custom query methods can be added here if needed
}
