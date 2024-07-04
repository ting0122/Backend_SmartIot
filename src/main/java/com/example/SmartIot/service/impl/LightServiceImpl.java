package com.example.SmartIot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SmartIot.constant.ResMsg;
import com.example.SmartIot.entity.Device;
import com.example.SmartIot.entity.Light;
import com.example.SmartIot.repository.DeviceRepository;
import com.example.SmartIot.repository.LightRepository;
import com.example.SmartIot.service.ifs.LightService;

@Service
public class LightServiceImpl implements LightService {

    @Autowired
    private LightRepository lightRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Light> getAllLights() {
        return lightRepository.findAll();
    }

    @Override
    public Light getLightById(Long id) {
        return lightRepository.findById(id).orElse(null);
    }

@Override
    public ResponseEntity<?> saveLight(Light light) {
        if (light == null || light.getDevice() == null || light.getDevice().getId() == null) {
            return new ResponseEntity<>(ResMsg.BAD_REQUEST.getDescription(), HttpStatus.BAD_REQUEST);
        }

        Device device = deviceRepository.findById(light.getDevice().getId()).orElse(null);
        if (device == null) {
            return new ResponseEntity<>(ResMsg.NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }

        // 檢查設備是否為燈
        if (!"light".equalsIgnoreCase(device.getType())) {
            return new ResponseEntity<>("This device is not a light", HttpStatus.BAD_REQUEST);
        }

        // 檢查亮度範圍
        if (light.getBrightness() < 0 || light.getBrightness() > 100) {
            return new ResponseEntity<>("Brightness must be between 0 and 100", HttpStatus.BAD_REQUEST);
        }

        // 檢查色溫範圍（假設範圍為1000K到10000K）
        if (light.getColor_temp() < 1000 || light.getColor_temp() > 10000) {
            return new ResponseEntity<>("Color temperature must be between 1000K and 10000K", HttpStatus.BAD_REQUEST);
        }

        // 更新設備狀態
        device.setStatus(light.getBrightness() > 0);
        deviceRepository.save(device);

        // 保存燈的設置
        light.setDevice(device);
        Light savedLight = lightRepository.save(light);

        return new ResponseEntity<>(savedLight, HttpStatus.OK);
    }

    @Override
    public void deleteLight(Long id) {
        lightRepository.deleteById(id);
    }
}
