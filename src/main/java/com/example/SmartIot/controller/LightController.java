package com.example.SmartIot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartIot.entity.Light;
import com.example.SmartIot.service.ifs.LightService;

@RestController
@RequestMapping("/lights")
public class LightController {

    @Autowired
    private LightService lightService;

    @GetMapping
    public List<Light> getAllLights() {
        return lightService.getAllLights();
    }

    @GetMapping("/{id}")
    public Light getLight(@PathVariable Long id) {
        return lightService.getLightById(id);
    }

    @PostMapping
    public ResponseEntity<?> saveLight(@RequestBody Light light) {
        return lightService.saveLight(light);
    }

    @DeleteMapping("/{id}")
    public void deleteLight(@PathVariable Long id) {
        lightService.deleteLight(id);
    }
}
