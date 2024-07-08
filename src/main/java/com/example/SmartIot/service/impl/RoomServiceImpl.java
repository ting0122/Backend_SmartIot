package com.example.SmartIot.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartIot.entity.Device;
import com.example.SmartIot.entity.Room;
import com.example.SmartIot.repository.RoomRepository;
import com.example.SmartIot.service.ifs.RoomService;
import com.example.SmartIot.vo.RoomReq;

import jakarta.validation.OverridesAttribute;

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
        rooms.forEach(this::sortAndGroupDevices);
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
    public List<Room> searchRooms(String name, String type, String area, Boolean status) {
        if (name != null && type != null && status != null) {
            // 根據名稱模糊查詢、類型查詢和狀態查詢
            return roomRepository.findByNameContainingAndTypeAndStatus(name, type, status);
        } else if (name != null && type != null) {
            // 根據名稱模糊查詢和類型查詢
            return roomRepository.findByNameContainingAndType(name, type);
        } else if (name != null && status != null) {
            // 根據名稱模糊查詢和狀態查詢
            return roomRepository.findByNameContainingAndStatus(name, status);
        } else if (type != null && status != null) {
            // 根據類型查詢和狀態查詢
            return roomRepository.findByTypeAndStatus(type, status);
        } else if (name != null) {
            // 根據名稱模糊查詢
            return roomRepository.findByNameContaining(name);
        } else if (type != null) {
            // 根據類型查詢
            return roomRepository.findByTypeContaining(type);
        } else if (area != null) {
            // 根據區域查詢唯一 Room
            return Arrays.asList(roomRepository.findByArea(area));
        } else if (status != null) {
            // 根據狀態查詢所有 Room
            return roomRepository.findByStatus(status);
        } else {
            // 返回空列表或者根據具體業務邏輯處理
            return Collections.emptyList();
        }
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
        room.setStatus(roomReq.getStatus());
        
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