package com.example.shems.service;

import com.example.shems.model.Device;
import com.example.shems.model.Customer;
import com.example.shems.model.Location;
import com.example.shems.repository.DeviceRepository;
import com.example.shems.repository.CustomerRepository;
import com.example.shems.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private CustomerRepository customerRepository;  // Assuming you have a CustomerRepository

    @Autowired
    private LocationRepository locationRepository;  // Assuming you have a LocationRepository

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
                    // Update the Customer reference
                    Optional<Customer> customer = customerRepository.findById(deviceDetails.getCustomer().getCustomerID());
                    customer.ifPresent(device::setCustomer);

                    // Update the Location reference
                    Optional<Location> location = locationRepository.findById(deviceDetails.getLocation().getLocationId());
                    location.ifPresent(device::setLocation);

                    // Update other properties
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
