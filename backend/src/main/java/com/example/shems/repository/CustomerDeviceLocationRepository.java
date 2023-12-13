package com.example.shems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.shems.dto.CustomerDeviceLocationDTO;
import com.example.shems.model.Customer;

import java.util.List;

public interface CustomerDeviceLocationRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT new com.example.shems.dto.CustomerDeviceLocationDTO(" +
    "c.customerID, c.firstName, c.lastName, " +
    "d.deviceId, d.type, d.model, d.manufacturer, d.status, " +
    "l.locationId, l.address, l.zipCode, l.squareFootage) " +
    "FROM Customer c " +
    "JOIN c.devices d " +
    "JOIN d.location l " +
    "WHERE c.customerID = :customerId " +
    "ORDER BY d.deviceId")
    List<CustomerDeviceLocationDTO> findCustomerDevicesAndLocations(@Param("customerId") Integer customerId);
}
