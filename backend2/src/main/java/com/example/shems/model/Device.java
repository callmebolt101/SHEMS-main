package com.example.shems.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deviceId;

    @Column(name = "CustomerID")
    private Integer customerId;

    @Column(name = "LocationID")
    private Integer locationId;

    @Column(name = "Type", length = 50)
    private String type;

    @Column(name = "Model", length = 50)
    private String model;

    @Column(name = "Manufacturer", length = 50)
    private String manufacturer;

    @Column(name = "Status", length = 50)
    private String status;

    // Getters
    public Integer getDeviceId() {
        return deviceId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
