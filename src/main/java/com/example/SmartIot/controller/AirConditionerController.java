package com.example.SmartIot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartIot.entity.AirConditioner;
import com.example.SmartIot.service.ifs.AirConditionerService;

@RestController
@RequestMapping("airconditioners")
public class AirConditionerController {
    
    @Autowired
    private AirConditionerService airConditionerService;

    @GetMapping
    public List<AirConditioner> getAllAirConditioners() {
        return airConditionerService.getAllAirConditioners();
    }

    @GetMapping("/{id}")
    public AirConditioner getAirConditioner(@PathVariable Long id) {
        return airConditionerService.getAirConditionerById(id);
    }

    @PostMapping
    public AirConditioner createAirConditioner(@RequestBody AirConditioner airConditioner) {
        return airConditionerService.saveAirConditioner(airConditioner);
    }

    @DeleteMapping("/{id}")
    public void deleteAirConditioner(@PathVariable Long id) {
        airConditionerService.deleteAirConditioner(id);
    }
    
}
