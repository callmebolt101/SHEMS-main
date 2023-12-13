package com.example.shems.service;

import com.example.shems.model.Location;
import com.example.shems.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Optional<Location> findById(Integer id) {
        return locationRepository.findById(id);
    }

    public Location save(Location location) {
        return locationRepository.save(location);
    }

    public Optional<Location> update(Integer id, Location locationDetails) {
        return locationRepository.findById(id)
                .map(location -> {
                    location.setAddress(locationDetails.getAddress());
                    location.setZipCode(locationDetails.getZipCode());
                    location.setSquareFootage(locationDetails.getSquareFootage());
                    return locationRepository.save(location);
                });
    }

    public boolean deleteById(Integer id) {
        return locationRepository.findById(id)
                .map(location -> {
                    locationRepository.delete(location);
                    return true;
                }).orElse(false);
    }
}
