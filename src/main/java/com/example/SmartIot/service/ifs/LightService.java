package com.example.SmartIot.service.ifs;

import java.util.List;

import com.example.SmartIot.entity.Light;

public interface LightService {

    List<Light> getAllLights();

    Light getLightById(Long id);

    Light saveLight(Light light);

    void deleteLight(Long id);
}
