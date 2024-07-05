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

import com.example.SmartIot.entity.Device;
import com.example.SmartIot.service.ifs.DeviceService;
import com.example.SmartIot.vo.DeviceReq;

@RestController
@RequestMapping("/")
public class DeviceController {
    
    @Autowired
    private DeviceService deviceService;

    //返回所有設備的列表
    @GetMapping("/")
    public List<Device> getAllDevices(){
        return deviceService.getAllDevices();
    }

    //返回特定 id 的設備
    @GetMapping("/devices/{id}")
    public Device getDeviceById(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }

    //從 Request 中讀取 JSON 資料並創建一個新的設備
    @PostMapping("/devices")
    public Device create(@RequestBody DeviceReq deviceReq) {
        return deviceService.saveDevice(deviceReq);
    }

    //刪除指定 ID 的設備
    @DeleteMapping("/devices/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }

}
