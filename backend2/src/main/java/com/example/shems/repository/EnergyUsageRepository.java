package com.example.shems.repository;

import com.example.shems.model.EnergyUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyUsageRepository extends JpaRepository<EnergyUsage, Integer> {
    // Custom query methods can be added here if needed
}
