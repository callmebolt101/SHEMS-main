package com.example.shems.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "EnergyUsage")
public class EnergyUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usageId;

    @Column(name = "DeviceID")
    private Integer deviceId;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Time")
    private Time time;

    @Column(name = "EnergyConsumed", precision = 10, scale = 2)
    private BigDecimal energyConsumed;

    @ManyToOne
    @JoinColumn(name = "DeviceID", referencedColumnName = "deviceId", insertable = false, updatable = false)
    private Device device;

    // Getters
    public Integer getUsageId() {
        return usageId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public BigDecimal getEnergyConsumed() {
        return energyConsumed;
    }

    // Setters
    public void setUsageId(Integer usageId) {
        this.usageId = usageId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setEnergyConsumed(BigDecimal energyConsumed) {
        this.energyConsumed = energyConsumed;
    }
}
