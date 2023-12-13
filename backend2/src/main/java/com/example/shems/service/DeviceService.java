package com.example.shems.service;

import com.example.shems.model.Device;
import com.example.shems.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    public Optional<Device> findById(Integer id) {
        return deviceRepository.findById(id);
    }

    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    public Optional<Device> update(Integer id, Device deviceDetails) {
        return deviceRepository.findById(id)
                .map(device -> {
                    device.setCustomerId(deviceDetails.getCustomerId());
                    device.setLocationId(deviceDetails.getLocationId());
                    device.setType(deviceDetails.getType());
                    device.setModel(deviceDetails.getModel());
                    device.setManufacturer(deviceDetails.getManufacturer());
                    device.setStatus(deviceDetails.getStatus());
                    return deviceRepository.save(device);
                });
    }

    public boolean deleteById(Integer id) {
        return deviceRepository.findById(id)
                .map(device -> {
                    deviceRepository.delete(device);
                    return true;
                }).orElse(false);
    }
}

