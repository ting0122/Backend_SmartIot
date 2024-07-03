package com.example.SmartIot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartIot.constant.AirConditionerConstants.FanSpeed;
import com.example.SmartIot.constant.AirConditionerConstants.Mode;
import com.example.SmartIot.service.ifs.AirConditionerService;
import com.example.SmartIot.vo.AirConditionerReq;
import com.example.SmartIot.vo.AirConditionerRes;

@RestController
@RequestMapping("/airconditioner")
public class AirConditionerController {

    @Autowired
    private AirConditionerService airConditionerService;

    @GetMapping("/{id}")
    public ResponseEntity<AirConditionerRes> getStatus(@PathVariable Long id) {
        try {
            AirConditionerRes res = airConditionerService.getStatus(id);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<AirConditionerRes> updateStatus(@RequestBody AirConditionerReq req) {
        try {
            AirConditionerRes res = airConditionerService.updateStatus(req);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}/turn-on")
    public ResponseEntity<AirConditionerRes> turnOn(@PathVariable Long id) {
        try {
            AirConditionerRes res = airConditionerService.turnOn(id);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/turn-off")
    public ResponseEntity<AirConditionerRes> turnOff(@PathVariable Long id) {
        try {
            AirConditionerRes res = airConditionerService.turnOff(id);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/set-temperature")
    public ResponseEntity<AirConditionerRes> setTemperature(@PathVariable Long id, @RequestParam Double temperature) {
        try {
            AirConditionerRes res = airConditionerService.setTemperature(id, temperature);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/set-mode")
    public ResponseEntity<AirConditionerRes> setMode(@PathVariable Long id, @RequestParam Mode mode) {
        try {
            AirConditionerRes res = airConditionerService.setMode(id, mode);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/set-fan-speed")
    public ResponseEntity<AirConditionerRes> setFanSpeed(@PathVariable Long id, @RequestParam FanSpeed fanSpeed) {
        try {
            AirConditionerRes res = airConditionerService.setFanSpeed(id, fanSpeed);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
