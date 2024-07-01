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
@Table(name = "ac")
public class AirConditioner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double current_temp;
    private Double target_temp;
    private String mode;
    private String fan_speed;

    //one ac mapped one device
    @OneToOne
    //use primary key as same as foreign key
    @MapsId
    //as id is equal device id
    @JoinColumn(name = "id")
    private Device device;


    //constructor
    public AirConditioner() {
    }


    public AirConditioner(Long id, Double current_temp, Double target_temp, String mode, String fan_speed, Device device) {
        this.id = id;
        this.current_temp = current_temp;
        this.target_temp = target_temp;
        this.mode = mode;
        this.fan_speed = fan_speed;
        this.device = device;
    }

    //getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCurrent_temp() {
        return this.current_temp;
    }

    public void setCurrent_temp(Double current_temp) {
        this.current_temp = current_temp;
    }

    public Double getTarget_temp() {
        return this.target_temp;
    }

    public void setTarget_temp(Double target_temp) {
        this.target_temp = target_temp;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getFan_speed() {
        return this.fan_speed;
    }

    public void setFan_speed(String fan_speed) {
        this.fan_speed = fan_speed;
    }

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}
