package com.example.SmartIot.vo;

import com.example.SmartIot.constant.AirConditionerConstants.Mode;
import com.example.SmartIot.constant.AirConditionerConstants.FanSpeed;

public class AirConditionerRes {

    private Long id;
    private Boolean isOn;
    private Double currentTemp;
    private Double targetTemp;
    private Mode mode;
    private FanSpeed fanSpeed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isOn() {
        return isOn;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }

    public Double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public Double getTargetTemp() {
        return targetTemp;
    }

    public void setTargetTemp(Double targetTemp) {
        this.targetTemp = targetTemp;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public FanSpeed getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(FanSpeed fanSpeed) {
        this.fanSpeed = fanSpeed;
    }
}