package com.example.SmartIot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SmartIot.entity.Device;
import com.example.SmartIot.entity.Room;
import com.example.SmartIot.repository.DeviceRepository;
import com.example.SmartIot.repository.RoomRepository;
import com.example.SmartIot.service.ifs.DeviceService;
import com.example.SmartIot.vo.DeviceReq;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final RoomRepository roomRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository,RoomRepository roomRepository) {
        this.deviceRepository = deviceRepository;
        this.roomRepository = roomRepository;
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

        return deviceRepository.save(device);
    }

     // 刪除指定 ID 的設備
    @Override
    public void deleteDevice(Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
        deviceRepository.delete(device);
    }
}
