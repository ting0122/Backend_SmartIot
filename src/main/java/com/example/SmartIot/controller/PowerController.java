package com.example.SmartIot.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import com.example.SmartIot.service.ifs.PowerService;

@CrossOrigin
@RestController
@RequestMapping("/power")
public class PowerController {

    @Autowired
    private PowerService powerService;

    //特定設備,特定日期使用時間(小時)
    @GetMapping("/device/{deviceId}/usage-time")
    public ResponseEntity<?> getDeviceUsageTime(@PathVariable Long deviceId, @RequestParam LocalDate date) {
        double usageTime = powerService.calculateDeviceUsageTime(deviceId, date);
        return new ResponseEntity<>(usageTime, HttpStatus.OK);
    }

    //特定房間,特定日期使用時間(小時)
    @GetMapping("/room/{roomId}/daily-consumption")
    public ResponseEntity<?> getRoomDailyConsumption(@PathVariable Long roomId, @RequestParam LocalDate date) {
        double consumption = powerService.calculateRoomDailyPowerConsumption(roomId, date);
        return new ResponseEntity<>(consumption, HttpStatus.OK);
    }

    //特定日期，總設備使用時間
    @GetMapping("/total-daily-consumption")
    public ResponseEntity<?> getTotalDailyConsumption(@RequestParam LocalDate date) {
        List<Map<String, Object>> consumption = powerService.calculateTotalDailyPowerConsumption(date);
        return new ResponseEntity<>(consumption, HttpStatus.OK);
    }

    //該月的的每日設備使用時間
    @GetMapping("/monthly-consumption")
    public ResponseEntity<?> getMonthlyConsumption(@RequestParam int year, @RequestParam int month) {
        Map<String, Double> consumption = powerService.calculateMonthlyPowerConsumption(year, month);
        return new ResponseEntity<>(consumption, HttpStatus.OK);
    }
}
