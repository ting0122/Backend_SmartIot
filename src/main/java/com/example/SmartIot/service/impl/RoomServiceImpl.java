package com.example.SmartIot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Override
    public List<Room> searchRooms(String name, String type, String area){
        if (name != null && type != null && area != null) {
            return roomRepository.findByNameContainingAndTypeAndArea(name, type, area);
        } else if (name != null && type != null) {
            return roomRepository.findByNameContainingAndType(name, type);
        } else if (name != null && area != null) {
            return roomRepository.findByNameContainingAndArea(name, area);
        } else if (name != null) {
            return roomRepository.findByNameContaining(name);
        } else if (type != null) {
            return roomRepository.findByTypeContaining(type);
        } else if (area != null) {
            return roomRepository.findByAreaContaining(area);
        } else {
            return roomRepository.findAll();
        }
    }

    @Override
    public Room createRoom(RoomReq roomReq) {

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
        
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}