package com.example.shems.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "EnergyPrice")
public class EnergyPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceId;

    @Column(name = "LocationID")
    private Integer locationId;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Time")
    private Time time;

    @Column(name = "PricePerUnit", precision = 10, scale = 2)
    private BigDecimal pricePerUnit;

    // Getters
    public Integer getPriceId() {
        return priceId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    // Setters
    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
