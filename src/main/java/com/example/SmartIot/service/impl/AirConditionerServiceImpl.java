package com.example.SmartIot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartIot.entity.AirConditioner;
import com.example.SmartIot.repository.AirConditionerRepository;
import com.example.SmartIot.service.ifs.AirConditionerService;

@Service
public class AirConditionerServiceImpl implements AirConditionerService {

    @Autowired
    private AirConditionerRepository airConditionerRepository;

    @Override
    public List<AirConditioner> getAllAirConditioners(){
        return airConditionerRepository.findAll();
    }

    @Override
    public AirConditioner getAirConditionerById(Long id) {
        return airConditionerRepository.findById(id).orElse(null);
    }

    @Override
    public AirConditioner saveAirConditioner(AirConditioner airConditioner) {
        return airConditionerRepository.save(airConditioner);
    }

    @Override
    public void deleteAirConditioner(Long id) {
        airConditionerRepository.deleteById(id);
    }
}
