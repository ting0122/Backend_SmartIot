package com.example.SmartIot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dehumidifier")
public class Dehumidifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double current_humidity;
    private Double target_humidity;
    private Double tank_capacity;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Device device;

    // constructor
    public Dehumidifier() {
    }

    public Dehumidifier(Long id, Double current_humidity, Double target_humidity, Double tank_capacity, Device device) {
        this.id = id;
        this.current_humidity = current_humidity;
        this.target_humidity = target_humidity;
        this.tank_capacity = tank_capacity;
        this.device = device;
    }

    // getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCurrent_humidity() {
        return this.current_humidity;
    }

    public void setCurrent_humidity(Double current_humidity) {
        this.current_humidity = current_humidity;
    }

    public Double getTarget_humidity() {
        return this.target_humidity;
    }

    public void setTarget_humidity(Double target_humidity) {
        this.target_humidity = target_humidity;
    }

    public Double getTank_capacity() {
        return this.tank_capacity;
    }

    public void setTank_capacity(Double tank_capacity) {
        this.tank_capacity = tank_capacity;
    }

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}
