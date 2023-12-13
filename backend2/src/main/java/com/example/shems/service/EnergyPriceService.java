package com.example.shems.service;

import com.example.shems.model.EnergyPrice;
import com.example.shems.repository.EnergyPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergyPriceService {

    @Autowired
    private EnergyPriceRepository energyPriceRepository;

    public List<EnergyPrice> findAll() {
        return energyPriceRepository.findAll();
    }

    public Optional<EnergyPrice> findById(Integer id) {
        return energyPriceRepository.findById(id);
    }

    public EnergyPrice save(EnergyPrice energyPrice) {
        return energyPriceRepository.save(energyPrice);
    }

    public Optional<EnergyPrice> update(Integer id, EnergyPrice energyPriceDetails) {
        return energyPriceRepository.findById(id)
                .map(energyPrice -> {
                    energyPrice.setLocationId(energyPriceDetails.getLocationId());
                    energyPrice.setDate(energyPriceDetails.getDate());
                    energyPrice.setTime(energyPriceDetails.getTime());
                    energyPrice.setPricePerUnit(energyPriceDetails.getPricePerUnit());
                    return energyPriceRepository.save(energyPrice);
                });
    }

    public boolean deleteById(Integer id) {
        return energyPriceRepository.findById(id)
                .map(energyPrice -> {
                    energyPriceRepository.delete(energyPrice);
                    return true;
                }).orElse(false);
    }
}
