package com.example.SmartIot.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SmartIot.constant.ResMsg;
import com.example.SmartIot.constant.AirConditionerConstants;
import com.example.SmartIot.entity.Device;
import com.example.SmartIot.entity.AirConditioner;
import com.example.SmartIot.repository.DeviceRepository;
import com.example.SmartIot.repository.AirConditionerRepository;
import com.example.SmartIot.service.ifs.AirConditionerService;

import jakarta.transaction.Transactional;

@Service
public class AirConditionerServiceImpl implements AirConditionerService {

    @Autowired
    private AirConditionerRepository airConditionerRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<AirConditioner> getAllAirConditioners() {
        return airConditionerRepository.findAll();
    }

    @Override
    public AirConditioner getAirConditionerById(Long id) {
        return airConditionerRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveAirConditioner(AirConditioner airConditioner) {
        if (airConditioner == null || airConditioner.getDevice() == null
                || airConditioner.getDevice().getId() == null) {
            return new ResponseEntity<>(ResMsg.BAD_REQUEST.getDescription(), HttpStatus.BAD_REQUEST);
        }

        Long deviceId = airConditioner.getDevice().getId();
        Device device = deviceRepository.findById(deviceId).orElse(null);
        if (device == null) {
            return new ResponseEntity<>(ResMsg.NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }

        // 檢查設備是否為空調機
        if (!"ac".equalsIgnoreCase(device.getType())) {
            return new ResponseEntity<>("This device is not an air conditioner", HttpStatus.BAD_REQUEST);
        }

        // 使用傳入的 AirConditioner 物件中的 Device 狀態
        Boolean newStatus = airConditioner.getDevice().getStatus();
        if (newStatus == null) {
            return new ResponseEntity<>("Device status cannot be null", HttpStatus.BAD_REQUEST);
        }

        // 更新設備狀態
        device.setStatus(newStatus);
        device = deviceRepository.save(device);

        // 檢查 AirConditioner 表中是否已存在此空調機
        AirConditioner existingAirConditioner = airConditionerRepository.findById(deviceId)
                .orElse(new AirConditioner());

        // 設定或更新 AirConditioner 的屬性
        existingAirConditioner.setCurrent_temp(airConditioner.getCurrent_temp());
        existingAirConditioner.setTarget_temp(airConditioner.getTarget_temp());
        existingAirConditioner.setMode(airConditioner.getMode());
        existingAirConditioner.setFanSpeed(airConditioner.getFanSpeed());
        existingAirConditioner.setDevice(device);

        // 保存空調機的設定
        AirConditioner savedAirConditioner = airConditionerRepository.save(existingAirConditioner);

        return new ResponseEntity<>(savedAirConditioner, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<?> patchAirConditioner(Long id, Map<String, Object> updates) {
        AirConditioner airConditioner = airConditionerRepository.findById(id).orElse(null);
        if (airConditioner == null) {
            return new ResponseEntity<>(ResMsg.NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }

        Device device = airConditioner.getDevice();
        if (device == null) {
            return new ResponseEntity<>("Associated device not found", HttpStatus.NOT_FOUND);
        }

        boolean statusChanged = false;

        // 開關空調機
        if (updates.containsKey("status")) {
            Object statusValue = updates.get("status");
            boolean newStatus;
            if (statusValue instanceof Integer) {
                newStatus = ((Integer) statusValue) == 1;
            } else if (statusValue instanceof Boolean) {
                newStatus = (Boolean) statusValue;
            } else {
                return new ResponseEntity<>("Invalid status value. Use 0, 1, true, or false", HttpStatus.BAD_REQUEST);
            }
            device.setStatus(newStatus);
            statusChanged = true;
        }

        // 更新當前溫度
        if (updates.containsKey("current_temp")) {
            airConditioner.setCurrent_temp((Double) updates.get("current_temp"));
        }

        // 更新目標溫度
        if (updates.containsKey("target_temp")) {
            airConditioner.setTarget_temp((Double) updates.get("target_temp"));
        }

        // 更新模式
        if (updates.containsKey("mode")) {
            try {
                airConditioner.setMode(AirConditionerConstants.Mode.valueOf((String) updates.get("mode")));
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>("Invalid mode value", HttpStatus.BAD_REQUEST);
            }
        }

        // 更新風速
        if (updates.containsKey("fan_speed")) {
            try {
                airConditioner.setFanSpeed(AirConditionerConstants.FanSpeed.valueOf((String) updates.get("fan_speed")));
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>("Invalid fan_speed value", HttpStatus.BAD_REQUEST);
            }
        }

        // 如果狀態有變化，保存 Device
        if (statusChanged) {
            deviceRepository.save(device);
        }

        AirConditioner savedAirConditioner = airConditionerRepository.save(airConditioner);
        return new ResponseEntity<>(savedAirConditioner, HttpStatus.OK);
    }

    @Override
    public void deleteAirConditioner(Long id) {
        airConditionerRepository.deleteById(id);
    }
}