package com.example.SmartIot.service.impl;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartIot.entity.Device;
import com.example.SmartIot.entity.Room;
import com.example.SmartIot.repository.RoomRepository;
import com.example.SmartIot.service.ifs.RoomService;
import com.example.SmartIot.vo.RoomReq;

import jakarta.transaction.Transactional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        for (Room room : rooms) {
            Set<Device> devices = room.getDevices();
            boolean roomStatus = devices.stream().anyMatch(Device::isStatus);
            room.setStatus(roomStatus);
        }
        roomRepository.saveAll(rooms);
        return rooms;
    }

    @Override
    public Room getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        sortAndGroupDevices(room);
        return room;
    }

    @Override
    public List<Room> searchRooms(String name, String type, String area, Boolean status){
        return roomRepository.findByCriteria(name, type, area, status);
    }

    @Override
    public Room createRoom(RoomReq roomReq) {

        Room existingRoom = roomRepository.findByArea(roomReq.getArea());
            if (existingRoom != null) {
                throw new RuntimeException("Room with this name already exists");
            }

        Room room;
        if (roomReq.getId() != null) {
            room = roomRepository.findById(roomReq.getId())
                    .orElseThrow(() -> new RuntimeException("Room not found"));
        } else {
            room = new Room();
        }

        room.setName(roomReq.getName());
        room.setArea(roomReq.getArea());
        room.setType(roomReq.getType());

         // 如果房間狀態被設置為關閉，同時關閉所有設備
         if (Boolean.FALSE.equals(roomReq.getStatus())) {
            Set<Device> devices = room.getDevices();
            if (devices != null) {
                for (Device device : devices) {
                    device.setStatus(false);
                }
            }
            else{
                throw new RuntimeException("Devices not found");
            }
        }
        
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    private void sortAndGroupDevices(Room room) {
        Map<String, List<Device>> groupedDevices = room.getDevices().stream()
                .sorted(Comparator.comparing(Device::getId))
                .collect(Collectors.groupingBy(Device::getType));

        Set<Device> sortedDevices = groupedDevices.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        room.setDevices(sortedDevices);
    }
}