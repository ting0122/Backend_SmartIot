package com.example.SmartIot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartIot.Repository.DeviceRepository;
import com.example.SmartIot.Repository.RoomRepository;
import com.example.SmartIot.entity.Device;
import com.example.SmartIot.entity.Room;
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

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @Override
    public Device createDevice(DeviceReq deviceReq) {

        Device device = new Device();
        device.setName(deviceReq.getName());
        device.setType(deviceReq.getType());
        device.setStatus(deviceReq.getStatus());
        device.setTime(deviceReq.getTime());
        return deviceRepository.save(device);
    }

    @Override
    public Device updateDevice(Long id, DeviceReq deviceReq) {
        Device existingDevice = deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));

        existingDevice.setName(deviceReq.getName());
        existingDevice.setType(deviceReq.getType());
        existingDevice.setStatus(deviceReq.getStatus());
        existingDevice.setTime(deviceReq.getTime());

        Room room = roomRepository.findById(deviceReq.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
        existingDevice.setRoom(room);

        return deviceRepository.save(existingDevice);
    }

    @Override
    public void deleteDevice(Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
        deviceRepository.delete(device);
    }
}
