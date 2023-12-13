package com.example.shems.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;

    @Column(name = "Address", length = 200)
    private String address;

    @Column(name = "ZipCode", length = 10)
    private String zipCode;

    @Column(name = "SquareFootage")
    private Integer squareFootage;

    // Getters
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

    // Setters
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
}
