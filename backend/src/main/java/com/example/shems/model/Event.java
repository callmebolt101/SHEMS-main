package com.example.shems.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;

    @Column(name = "DeviceID")
    private Integer deviceId;

    @Column(name = "Timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(name = "EventType", length = 100)
    private String eventType;

    @Column(name = "Value", length = 100)
    private String value;

    // Getters
    public Integer getEventId() {
        return eventId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getEventType() {
        return eventType;
    }

    public String getValue() {
        return value;
    }

    // Setters
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
