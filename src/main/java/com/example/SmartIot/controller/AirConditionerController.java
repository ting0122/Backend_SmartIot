package com.example.SmartIot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartIot.constant.AirConditionerConstants.FanSpeed;
import com.example.SmartIot.constant.AirConditionerConstants.Mode;
import com.example.SmartIot.constant.AirConditionerResponseMessage;
import com.example.SmartIot.service.ifs.AirConditionerService;
import com.example.SmartIot.vo.AirConditionerReq;
import com.example.SmartIot.vo.AirConditionerRes;

@CrossOrigin
@RestController
@RequestMapping("/api/airconditioner")
public class AirConditionerController {

    @Autowired
    private AirConditionerService airConditionerService;

    /*
     * 取得空調機的狀態
     * GET:http://localhost:8080/api/airconditioner/1
     */
    @GetMapping("/{id}")
    public ResponseEntity<AirConditionerRes> getStatus(@PathVariable("id") Long id) {
        try {
            AirConditionerRes res = airConditionerService.getStatus(id);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.status(AirConditionerResponseMessage.NOT_FOUND.getCode())
                    .body(new AirConditionerRes(AirConditionerResponseMessage.NOT_FOUND));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<AirConditionerRes> updateStatus(@RequestBody AirConditionerReq req) {
        try {
            AirConditionerRes res = airConditionerService.updateStatus(req);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.status(AirConditionerResponseMessage.INVALID_OPERATION.getCode())
                    .body(new AirConditionerRes(AirConditionerResponseMessage.INVALID_OPERATION));
        }
    }

    /*
     * 開機
     * POST:http://localhost:8080/api/airconditioner/1/turn-on
     */
    @PostMapping("/{id}/turn-on")
    public ResponseEntity<AirConditionerRes> turnOn(@PathVariable("id") Long id) {
        try {
            AirConditionerRes res = airConditionerService.turnOn(id);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.status(AirConditionerResponseMessage.NOT_FOUND.getCode())
            .body(new AirConditionerRes(AirConditionerResponseMessage.NOT_FOUND));
        }
    }

    /*
     * 關機
     * POST:http://localhost:8080/api/airconditioner/1/turn-off
     */
    @PostMapping("/{id}/turn-off")
    public ResponseEntity<AirConditionerRes> turnOff(@PathVariable("id") Long id) {
        try {
            AirConditionerRes res = airConditionerService.turnOff(id);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.status(AirConditionerResponseMessage.NOT_FOUND.getCode())
            .body(new AirConditionerRes(AirConditionerResponseMessage.NOT_FOUND));
        }
    }

    /*
     * 設定溫度
     * POST:http://localhost:8080/api/airconditioner/1/set-temperature?temperature=28
     */
    @PostMapping("/{id}/set-temperature")
    public ResponseEntity<AirConditionerRes> setTemperature(@PathVariable("id") Long id, @RequestParam Double temperature) {
        try {
            AirConditionerRes res = airConditionerService.setTemperature(id, temperature);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(AirConditionerResponseMessage.NOT_FOUND.getCode())
                    .body(new AirConditionerRes(AirConditionerResponseMessage.NOT_FOUND));
        }
    }

    /*
     * 設定模式
     * POST:http://localhost:8080/api/airconditioner/1/set-mode?mode=COOL
     */
    @PostMapping("/{id}/set-mode")
    public ResponseEntity<AirConditionerRes> setMode(@PathVariable("id") Long id, @RequestParam Mode mode) {
        try {
            AirConditionerRes res = airConditionerService.setMode(id, mode);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.status(AirConditionerResponseMessage.NOT_FOUND.getCode())
            .body(new AirConditionerRes(AirConditionerResponseMessage.NOT_FOUND));
        }
    }

    /*
     * 設定風速
     * POST:http://localhost:8080/api/airconditioner/1/set-fan-speed?fanSpeed=MEDIUM
     */
    @PostMapping("/{id}/set-fan-speed")
    public ResponseEntity<AirConditionerRes> setFanSpeed(@PathVariable("id") Long id, @RequestParam FanSpeed fanSpeed) {
        try {
            AirConditionerRes res = airConditionerService.setFanSpeed(id, fanSpeed);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.status(AirConditionerResponseMessage.NOT_FOUND.getCode())
            .body(new AirConditionerRes(AirConditionerResponseMessage.NOT_FOUND));
        }
    }
}
