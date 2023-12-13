package com.example.shems.repository;

import com.example.shems.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    // Custom query methods can be added here if needed
}

