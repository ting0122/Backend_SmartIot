package com.example.SmartIot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartIot.entity.Light;
import com.example.SmartIot.service.ifs.LightService;

@CrossOrigin
@RestController
@RequestMapping("/lights")
public class LightController {
    
    @Autowired
    private LightService lightService;

    //獲取所有燈
    @GetMapping
    public List<Light> getAllLights() {
        return lightService.getAllLights();
    }

    //獲取特定的燈
    @GetMapping("/{id}")
    public Light getLight(@PathVariable("id") Long id) {
        return lightService.getLightById(id);
    }

    //新增或修改燈
    @PostMapping
    public Light createLight(@RequestBody Light light) {
        //save 方法會判定有無id決定創建或修改
        return lightService.saveLight(light);
    }

    //刪除燈
    @DeleteMapping("/{id}")
    public void deleteLight(@PathVariable("id") Long id) {
        lightService.deleteLight(id);
    }
}
