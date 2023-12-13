package com.example.shems.repository;

import com.example.shems.model.EnergyPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyPriceRepository extends JpaRepository<EnergyPrice, Integer> {
    // Custom query methods can be added here if needed
}
