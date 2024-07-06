package com.example.SmartIot.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.SmartIot.constant.ResMsg;
import com.example.SmartIot.entity.Dehumidifier;
import com.example.SmartIot.entity.Device;
import com.example.SmartIot.repository.DehumidifierRepository;
import com.example.SmartIot.repository.DeviceRepository;
import com.example.SmartIot.service.ifs.DehumidifierService;

import jakarta.transaction.Transactional;

@Service
public class DehumidifierServiceImpl implements DehumidifierService {
    
    @Autowired
    private DehumidifierRepository dehumidifierRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Dehumidifier> getAllDehumidifiers() {
        return dehumidifierRepository.findAll();
    }

    @Override
    public Dehumidifier getDehumidifierById(Long id) {
        return dehumidifierRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveDehumidifier(Dehumidifier dehumidifier) {
        if (dehumidifier == null || dehumidifier.getDevice() == null || dehumidifier.getDevice().getId() == null) {
            return new ResponseEntity<>(ResMsg.BAD_REQUEST.getDescription(), HttpStatus.BAD_REQUEST);
        }

        Long deviceId = dehumidifier.getDevice().getId();
        Device device = deviceRepository.findById(deviceId).orElse(null);
        if (device == null) {
            return new ResponseEntity<>(ResMsg.NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }

        // 檢查設備是否為除濕機
        if (!"dehumidifier".equalsIgnoreCase(device.getType())) {
            return new ResponseEntity<>("This device is not a dehumidifier", HttpStatus.BAD_REQUEST);
        }

        // 使用傳入的 Dehumidifier 物件中的 Device 狀態
        Boolean newStatus = dehumidifier.getDevice().getStatus();
        if (newStatus == null) {
            return new ResponseEntity<>("Device status cannot be null", HttpStatus.BAD_REQUEST);
        }

        // 更新設備狀態
        device.setStatus(newStatus);
        device = deviceRepository.save(device);

        // 檢查 Dehumidifier 表中是否已存在此除濕機
        Dehumidifier existingDehumidifier = dehumidifierRepository.findById(deviceId).orElse(new Dehumidifier());

        // 設定或更新 Dehumidifier 的屬性
        existingDehumidifier.setCurrent_humidity(dehumidifier.getCurrent_humidity());
        existingDehumidifier.setTarget_humidity(dehumidifier.getTarget_humidity());
        existingDehumidifier.setTank_capacity(dehumidifier.getTank_capacity());
        existingDehumidifier.setDevice(device);

        // 保存除濕機的設定
        Dehumidifier savedDehumidifier = dehumidifierRepository.save(existingDehumidifier);

        return new ResponseEntity<>(savedDehumidifier, HttpStatus.OK);
    }

    @Override
    public void deleteDehumidifier(Long id) {
        dehumidifierRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ResponseEntity<?> patchDehumidifier(Long id, Map<String, Object> updates) {
        Dehumidifier dehumidifier = dehumidifierRepository.findById(id).orElse(null);
        if (dehumidifier == null) {
            return new ResponseEntity<>(ResMsg.NOT_FOUND.getDescription(), HttpStatus.NOT_FOUND);
        }

        Device device = dehumidifier.getDevice();
        if (device == null) {
            return new ResponseEntity<>("Associated device not found", HttpStatus.NOT_FOUND);
        }

        boolean statusChanged = false;
        
        // 開關除濕機
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

        // 更新當前濕度
        if (updates.containsKey("current_humidity")) {
            Double currentHumidity = (Double) updates.get("current_humidity");
            if (currentHumidity < 0 || currentHumidity > 100) {
                return new ResponseEntity<>("Current humidity must be between 0 and 100", HttpStatus.BAD_REQUEST);
            }
            dehumidifier.setCurrent_humidity(currentHumidity);
        }

        // 更新目標濕度
        if (updates.containsKey("target_humidity")) {
            Double targetHumidity = (Double) updates.get("target_humidity");
            if (targetHumidity < 0 || targetHumidity > 100) {
                return new ResponseEntity<>("Target humidity must be between 0 and 100", HttpStatus.BAD_REQUEST);
            }
            dehumidifier.setTarget_humidity(targetHumidity);
        }

        // 更新水箱容量
        if (updates.containsKey("tank_capacity")) {
            Double tankCapacity = (Double) updates.get("tank_capacity");
            if (tankCapacity < 0) {
                return new ResponseEntity<>("Tank capacity cannot be negative", HttpStatus.BAD_REQUEST);
            }
            dehumidifier.setTank_capacity(tankCapacity);
        }

        // 如果狀態有變化，保存 Device
        if (statusChanged) {
            deviceRepository.save(device);
        }

        Dehumidifier savedDehumidifier = dehumidifierRepository.save(dehumidifier);
        return new ResponseEntity<>(savedDehumidifier, HttpStatus.OK);
    }
}
