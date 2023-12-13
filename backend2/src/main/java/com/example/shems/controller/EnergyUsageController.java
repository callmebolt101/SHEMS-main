package com.example.shems.controller;

import com.example.shems.model.EnergyUsage;
import com.example.shems.service.EnergyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energyUsages")
public class EnergyUsageController {

    @Autowired
    private EnergyUsageService energyUsageService;

    @GetMapping
    public List<EnergyUsage> getAllEnergyUsages() {
        return energyUsageService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnergyUsage> getEnergyUsageById(@PathVariable Integer id) {
        return energyUsageService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EnergyUsage createEnergyUsage(@RequestBody EnergyUsage energyUsage) {
        return energyUsageService.save(energyUsage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnergyUsage> updateEnergyUsage(@PathVariable Integer id, @RequestBody EnergyUsage energyUsageDetails) {
        return energyUsageService.update(id, energyUsageDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnergyUsage(@PathVariable Integer id) {
        return energyUsageService.deleteById(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}