package com.example.SmartIot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartIot.entity.Device;
import com.example.SmartIot.service.ifs.DeviceService;
import com.example.SmartIot.vo.DeviceReq;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class DeviceController {
    
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevices(){
        return deviceService.getAllDevices();
    }

    @GetMapping("/devices/{id}")
    public Device getDeviceById(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }

    @PostMapping("/devices")
    public Device createDevice(@RequestBody DeviceReq deviceReq) {
        return deviceService.createDevice(deviceReq);
    }

    @PutMapping("/devices/{id}")
    public Device updateDevice(@PathVariable Long id, @Valid @RequestBody DeviceReq deviceReq) {
        return deviceService.updateDevice(id, deviceReq);
    }

    @DeleteMapping("/devices/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }

}
