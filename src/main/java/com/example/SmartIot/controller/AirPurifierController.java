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

import com.example.SmartIot.entity.AirPurifier;
import com.example.SmartIot.service.ifs.AirPurifierService;

@RestController
@RequestMapping("/air-purifiers")
public class AirPurifierController {

    @Autowired
    private AirPurifierService airPurifierService;

    @GetMapping
    public List<AirPurifier> getAllAirPurifiers() {
        return airPurifierService.getAllAirPurifiers();
    }

    @GetMapping("/{id}")
    public AirPurifier getAirPurifier(@PathVariable Long id) {
        return airPurifierService.getAirPurifierById(id);
    }

    @PostMapping
    public AirPurifier createAirPurifier(@RequestBody AirPurifier airPurifier) {
        return airPurifierService.saveAirPurifier(airPurifier);
    }

    @DeleteMapping("/{id}")
    public void deleteAirPurifier(@PathVariable Long id) {
        airPurifierService.deleteAirPurifier(id);
    }
}
