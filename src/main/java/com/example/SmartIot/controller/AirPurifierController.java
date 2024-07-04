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

    //所有空氣清淨機
    @GetMapping
    public List<AirPurifier> getAllAirPurifiers() {
        return airPurifierService.getAllAirPurifiers();
    }

    //特定 id 的空氣清淨機
    @GetMapping("/{id}")
    public AirPurifier getAirPurifier(@PathVariable Long id) {
        return airPurifierService.getAirPurifierById(id);
    }

    //新增或修改空氣清淨機
    @PostMapping
    public AirPurifier createAirPurifier(@RequestBody AirPurifier airPurifier) {
        //save 方法會判定有無id決定創建或修改
        return airPurifierService.saveAirPurifier(airPurifier);
    }

    //刪除空氣清淨機
    @DeleteMapping("/{id}")
    public void deleteAirPurifier(@PathVariable Long id) {
        airPurifierService.deleteAirPurifier(id);
    }
}
