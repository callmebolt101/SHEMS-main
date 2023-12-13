package com.example.shems.service;

import com.example.shems.model.EnergyUsage;
import com.example.shems.repository.EnergyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergyUsageService {

    @Autowired
    private EnergyUsageRepository energyUsageRepository;

    public List<EnergyUsage> findAll() {
        return energyUsageRepository.findAll();
    }

    public Optional<EnergyUsage> findById(Integer id) {
        return energyUsageRepository.findById(id);
    }

    public EnergyUsage save(EnergyUsage energyUsage) {
        return energyUsageRepository.save(energyUsage);
    }

    public Optional<EnergyUsage> update(Integer id, EnergyUsage energyUsageDetails) {
        return energyUsageRepository.findById(id)
                .map(energyUsage -> {
                    energyUsage.setDeviceId(energyUsageDetails.getDeviceId());
                    energyUsage.setDate(energyUsageDetails.getDate());
                    energyUsage.setTime(energyUsageDetails.getTime());
                    energyUsage.setEnergyConsumed(energyUsageDetails.getEnergyConsumed());
                    return energyUsageRepository.save(energyUsage);
                });
    }

    public boolean deleteById(Integer id) {
        return energyUsageRepository.findById(id)
                .map(energyUsage -> {
                    energyUsageRepository.delete(energyUsage);
                    return true;
                }).orElse(false);
    }
}
