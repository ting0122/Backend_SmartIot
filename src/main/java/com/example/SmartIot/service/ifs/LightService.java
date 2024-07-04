package com.example.SmartIot.service.ifs;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.SmartIot.entity.Light;

public interface LightService {

    List<Light> getAllLights();

    Light getLightById(Long id);

    ResponseEntity<?> saveLight(Light light);

    void deleteLight(Long id);
}
