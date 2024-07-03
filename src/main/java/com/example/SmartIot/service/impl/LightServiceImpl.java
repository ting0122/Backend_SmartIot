package com.example.SmartIot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartIot.entity.Light;
import com.example.SmartIot.repository.LightRepository;
import com.example.SmartIot.service.ifs.LightService;

@Service
public class LightServiceImpl implements LightService{
    
    @Autowired
    private LightRepository lightRepository;

    @Override
    public List<Light> getAllLights() {
        return lightRepository.findAll();
    }

    @Override
    public Light getLightById(Long id) {
        return lightRepository.findById(id).orElse(null);
    }

    @Override
    public Light saveLight(Light light) {
        return lightRepository.save(light);
    }

    @Override
    public void deleteLight(Long id) {
        lightRepository.deleteById(id);
    }
}
