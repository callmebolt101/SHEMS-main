package com.example.shems.repository;

import com.example.shems.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    // Custom query methods can be added here if needed
}
