package com.example.SmartIot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SmartIot.entity.AirConditioner;
import com.example.SmartIot.entity.AirPurifier;
import com.example.SmartIot.entity.Dehumidifier;
import com.example.SmartIot.entity.Device;
import com.example.SmartIot.entity.Light;
import com.example.SmartIot.entity.Room;
import com.example.SmartIot.repository.AirConditionerRepository;
import com.example.SmartIot.repository.AirPurifierRepository;
import com.example.SmartIot.repository.DehumidifierRepository;
import com.example.SmartIot.repository.DeviceRepository;
import com.example.SmartIot.repository.LightRepository;
import com.example.SmartIot.repository.RoomRepository;
import com.example.SmartIot.service.ifs.DeviceService;
import com.example.SmartIot.vo.DeviceReq;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final RoomRepository roomRepository;
    private final AirPurifierRepository airPurifierRepository;
    private final DehumidifierRepository dehumidifierRepository;
    private final LightRepository lightRepository;
    private final AirConditionerRepository airConditionerRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository,RoomRepository roomRepository,AirPurifierRepository airPurifierRepository,DehumidifierRepository dehumidifierRepository,LightRepository lightRepository,AirConditionerRepository airConditionerRepository) {
        this.deviceRepository = deviceRepository;
        this.roomRepository = roomRepository;
        this.airPurifierRepository = airPurifierRepository;
        this.dehumidifierRepository = dehumidifierRepository;
        this.lightRepository = lightRepository;
        this.airConditionerRepository = airConditionerRepository;
    }

    // 返回所有設備的列表
    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

     // 根據設備 ID 返回相應的設備，如果找不到則拋出異常
    @Override
    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
    }

    // 搜尋設備 名稱及種類 
    @Override
    public List<Device> searchDevices(String name, String type, Boolean status){
        return deviceRepository.findByCriteria(name, type, status);
    }

    // 創建新設備 或 更新設備
    @Override
    public Device saveDevice(DeviceReq deviceReq) {

        Device device;
        //如果有 id 就更新設備
        if (deviceReq.getId() != null) {
            device = deviceRepository.findById(deviceReq.getId())
                    .orElseThrow(() -> new RuntimeException("Device not found"));
        } else {
            // 沒 id 就創建新設備
            device = new Device();
        }

        device.setName(deviceReq.getName());
        device.setType(deviceReq.getType());
        device.setStatus(deviceReq.getStatus());
        device.setTime(deviceReq.getTime());

        //是否放在哪個房間
        if (deviceReq.getRoomId() != null) {
            Room room = roomRepository.findById(deviceReq.getRoomId())
                    .orElseThrow(() -> new RuntimeException("Room not found with id " + deviceReq.getRoomId()));
            device.setRoom(room);
        } else {
            //沒有就 null
            device.setRoom(null);
        }

        Device savedDevice = deviceRepository.save(device);

        // 根據設備類型在相關表中新增資訊
        switch(device.getType()) {
            case "空氣清淨機":
                AirPurifier airPurifier = new AirPurifier();
                airPurifier.setDevice(savedDevice);
                airPurifier.setAir_quality(0);
                airPurifier.setFan_speed(0);
                airPurifier.setOperating_time(0.0);
                airPurifierRepository.save(airPurifier);
                break;

            case "除濕機":
                Dehumidifier dehumidifier = new Dehumidifier();
                dehumidifier.setDevice(savedDevice);
                dehumidifier.setCurrent_humidity(0.0);
                dehumidifier.setTarget_humidity(0.0);
                dehumidifier.setTank_capacity(0.0);
                dehumidifierRepository.save(dehumidifier);
                break;

            case "燈":
                Light light = new Light();
                light.setDevice(savedDevice);
                light.setBrightness(0);
                light.setColor_temp(0);
                lightRepository.save(light);
                break;

            case "冷氣機":
                AirConditioner airConditioner;
                if (deviceReq.getId() != null) {
                    airConditioner = airConditionerRepository.findById(deviceReq.getId())
                        .orElseThrow(() -> new RuntimeException("AirConditioner not found"));
                } else {
                    airConditioner = new AirConditioner();
                }
                airConditioner.setDevice(savedDevice);
                airConditioner.setCurrent_temp(airConditioner.getCurrent_temp() != null ? airConditioner.getCurrent_temp() : 0.0);
                airConditioner.setTarget_temp(airConditioner.getTarget_temp() != null ? airConditioner.getTarget_temp() : 0.0);
                airConditionerRepository.save(airConditioner);
                break;

            // 可新增其他設備類型

            default:
                throw new RuntimeException("Unsupported device type: " + device.getType());
        }
        return savedDevice;
    }

     // 刪除指定 ID 的設備
    @Override
    public void deleteDevice(Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
        switch (device.getType()) {
            case "空氣清淨機":
                airPurifierRepository.deleteById(id);
                break;
            case "除濕機":
                dehumidifierRepository.deleteById(id);
                break;
            case "燈":
                lightRepository.deleteById(id);
                break;
            case "冷氣機":
                airConditionerRepository.deleteById(id);
                break;
            default:
                throw new RuntimeException("Unsupported device type: " + device.getType());
        }
        deviceRepository.delete(device);
    }
}
