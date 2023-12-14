package com.example.shems.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class CustomerDeviceLocationDTO {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private Integer deviceId;
    private String type;
    private String model;
    private String manufacturer;
    private String status;
    private Integer locationId;
    private String address;
    private String zipCode;
    private Integer squareFootage;
    private BigDecimal totalEnergyConsumedByDevice;
    private BigDecimal totalEnergyConsumedAllDevices;


    // Default constructor
    public CustomerDeviceLocationDTO() {
    }

    // Constructor with all fields, including energy usage data
    public CustomerDeviceLocationDTO(Integer customerId, String firstName, String lastName, 
                                     Integer deviceId, String type, String model, 
                                     String manufacturer, String status, Integer locationId, 
                                     String address, String zipCode, Integer squareFootage,
                                     BigDecimal totalEnergyConsumedByDevice, BigDecimal totalEnergyConsumedAllDevices
                                     ) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deviceId = deviceId;
        this.type = type;
        this.model = model;
        this.manufacturer = manufacturer;
        this.status = status;
        this.locationId = locationId;
        this.address = address;
        this.zipCode = zipCode;
        this.squareFootage = squareFootage;
        this.totalEnergyConsumedByDevice = totalEnergyConsumedByDevice;
        this.totalEnergyConsumedAllDevices = totalEnergyConsumedAllDevices;
    }

    // Getters
    public Integer getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDeviceId() {
        return deviceId;
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

    public Integer getLocationId() {
        return locationId;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Integer getSquareFootage() {
        return squareFootage;
    }

    public BigDecimal getTotalEnergyConsumedByDevice() {
        return totalEnergyConsumedByDevice;
    }

    public void setTotalEnergyConsumedByDevice(BigDecimal totalEnergyConsumedByDevice) {
        this.totalEnergyConsumedByDevice = totalEnergyConsumedByDevice;
    }

    // Setters
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
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

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setSquareFootage(Integer squareFootage) {
        this.squareFootage = squareFootage;
    }

    public BigDecimal getTotalEnergyConsumedAllDevices() {
        return totalEnergyConsumedAllDevices;
    }

    public void setTotalEnergyConsumedAllDevices(BigDecimal totalEnergyConsumedAllDevices) {
        this.totalEnergyConsumedAllDevices = totalEnergyConsumedAllDevices;
    }


    @Override
    public String toString() {
        return "CustomerDeviceLocationDTO{" +
               "customerId=" + customerId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", deviceId=" + deviceId +
               ", type='" + type + '\'' +
               ", model='" + model + '\'' +
               ", manufacturer='" + manufacturer + '\'' +
               ", status='" + status + '\'' +
               ", locationId=" + locationId +
               ", address='" + address + '\'' +
               ", zipCode='" + zipCode + '\'' +
               ", squareFootage=" + squareFootage +
               ", totalEnergyConsumedByDevice=" + totalEnergyConsumedByDevice +
               ", totalEnergyConsumedAllDevices=" + totalEnergyConsumedAllDevices +
               '}';
    }
}
