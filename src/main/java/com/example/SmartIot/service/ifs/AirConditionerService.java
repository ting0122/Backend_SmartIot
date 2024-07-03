package com.example.SmartIot.service.ifs;

import java.util.List;

import com.example.SmartIot.entity.AirConditioner;

public interface AirConditionerService {

    List<AirConditioner> getAllAirConditioners();

    AirConditioner getAirConditionerById(Long id);

    AirConditioner saveAirConditioner(AirConditioner airConditioner);

    void deleteAirConditioner(Long id);

}
