package com.example.SmartIot.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;



@Entity
@Table(name = "history")
public class History {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private String eventId;

    @Column(name = "device_id")
    private Long deviceId;

    @Column(name = "event_time")
    private LocalDateTime eventTime;

    @Column(name = "event_type")
    private String eventType;

    @Lob
    @Column(name = "detail")
    private String detail;

    //constructor
    public History() {
    }

    public History(Long id, String eventId, Long deviceId, LocalDateTime eventTime, String eventType, String detail) {
        this.id = id;
        this.eventId = eventId;
        this.deviceId = deviceId;
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.detail = detail;
    }

    @PrePersist
    public void prePersist() {
        if (this.eventTime == null) {
            this.eventTime = LocalDateTime.now();
        }
        if (this.eventId == null) {
            this.eventId = UUID.randomUUID().toString();
        }
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    
    
}
