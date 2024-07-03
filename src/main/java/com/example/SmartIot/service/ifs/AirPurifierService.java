package com.example.SmartIot.service.ifs;

import java.util.List;

import com.example.SmartIot.entity.AirPurifier;

public interface AirPurifierService {

    List<AirPurifier> getAllAirPurifiers();

    AirPurifier getAirPurifierById(Long id);

    AirPurifier saveAirPurifier(AirPurifier airPurifier);

    void deleteAirPurifier(Long id);
}
