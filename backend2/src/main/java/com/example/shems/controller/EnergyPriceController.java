package com.example.shems.controller;

import com.example.shems.model.EnergyPrice;
import com.example.shems.service.EnergyPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energyPrices")
public class EnergyPriceController {

    @Autowired
    private EnergyPriceService energyPriceService;

    @GetMapping
    public List<EnergyPrice> getAllEnergyPrices() {
        return energyPriceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnergyPrice> getEnergyPriceById(@PathVariable Integer id) {
        return energyPriceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EnergyPrice createEnergyPrice(@RequestBody EnergyPrice energyPrice) {
        return energyPriceService.save(energyPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnergyPrice> updateEnergyPrice(@PathVariable Integer id, @RequestBody EnergyPrice energyPriceDetails) {
        return energyPriceService.update(id, energyPriceDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnergyPrice(@PathVariable Integer id) {
        return energyPriceService.deleteById(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}
