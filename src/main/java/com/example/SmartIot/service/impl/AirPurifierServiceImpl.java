package com.example.SmartIot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartIot.entity.AirPurifier;
import com.example.SmartIot.repository.AirPurifierRepository;
import com.example.SmartIot.service.ifs.AirPurifierService;

@Service
public class AirPurifierServiceImpl implements AirPurifierService{
    
    @Autowired
    private AirPurifierRepository airPurifierRepository;

    @Override
    public List<AirPurifier> getAllAirPurifiers() {
        return airPurifierRepository.findAll();
    }

    @Override
    public AirPurifier getAirPurifierById(Long id) {
        return airPurifierRepository.findById(id).orElse(null);
    }

    @Override
    public AirPurifier saveAirPurifier(AirPurifier airPurifier) {
        return airPurifierRepository.save(airPurifier);
    }

    @Override
    public void deleteAirPurifier(Long id) {
        airPurifierRepository.deleteById(id);
    }
}
