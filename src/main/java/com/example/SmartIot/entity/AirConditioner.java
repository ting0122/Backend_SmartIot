package com.example.SmartIot.entity;

import jakarta.persistence.*;
import com.example.SmartIot.constant.AirConditionerConstants.Mode;
import com.example.SmartIot.constant.AirConditionerConstants.FanSpeed;

@Entity
@Table(name = "ac")
public class AirConditioner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double current_temp;
    private Double target_temp;
    @Enumerated(EnumType.STRING)
    private Mode mode;

    @Enumerated(EnumType.STRING)
    @Column(name = "fan_speed")
    private FanSpeed fanSpeed;


    //one ac mapped one device
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Device device;

    //constructor
    public AirConditioner() {
    }


    public AirConditioner(Long id, Double current_temp, Double target_temp, Mode mode, FanSpeed fanSpeed, Device device) {
        this.id = id;
        this.current_temp = current_temp;
        this.target_temp = target_temp;
        this.mode = mode;
        this.fanSpeed = fanSpeed;
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

    public Mode getMode() {
        return this.mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public FanSpeed getFanSpeed() {
        return this.fanSpeed;
    }

    public void setFanSpeed(FanSpeed fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}
