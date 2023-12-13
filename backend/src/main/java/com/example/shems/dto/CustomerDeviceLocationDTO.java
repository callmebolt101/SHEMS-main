package com.example.shems.dto;

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

    // Default constructor
    public CustomerDeviceLocationDTO() {
    }

    // Constructor with all fields
    public CustomerDeviceLocationDTO(Integer customerId, String firstName, String lastName, 
                                     Integer deviceId, String type, String model, 
                                     String manufacturer, String status, Integer locationId, 
                                     String address, String zipCode, Integer squareFootage) {
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
    }

    // Getters and setters

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(Integer squareFootage) {
        this.squareFootage = squareFootage;
    }

    // Optional: Override toString() for easy logging or debugging

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
               '}';
    }
}

