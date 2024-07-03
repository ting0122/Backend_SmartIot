package com.example.SmartIot.service.ifs;

import com.example.SmartIot.vo.AirConditionerReq;
import com.example.SmartIot.vo.AirConditionerRes;
import com.example.SmartIot.constant.AirConditionerConstants.Mode;
import com.example.SmartIot.constant.AirConditionerConstants.FanSpeed;


public interface AirConditionerService {
    AirConditionerRes getStatus(Long id);
    AirConditionerRes updateStatus(AirConditionerReq req);
    AirConditionerRes turnOn(Long id);
    AirConditionerRes turnOff(Long id);
    AirConditionerRes setTemperature(Long id, Double temperature);
    AirConditionerRes setMode(Long id, Mode mode);
    AirConditionerRes setFanSpeed(Long id, FanSpeed fanSpeed);
}