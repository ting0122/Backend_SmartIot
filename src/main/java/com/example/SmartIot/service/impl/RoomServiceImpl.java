package com.example.SmartIot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartIot.entity.Room;
import com.example.SmartIot.repository.RoomRepository;
import com.example.SmartIot.service.ifs.RoomService;
import com.example.SmartIot.vo.RoomReq;

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
    public Room createRoom(RoomReq roomReq) {
        Room room = new Room();
        room.setName(roomReq.getName());
        room.setArea(roomReq.getArea());
        room.setDescription(roomReq.getDescription());
        // 可能還有其他屬性需要設置
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long id, RoomReq roomReq) {
        Room roomToUpdate = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        
        roomToUpdate.setName(roomReq.getName());
        roomToUpdate.setArea(roomReq.getArea());
        roomToUpdate.setDescription(roomReq.getDescription());
        // 可能還有其他屬性需要設置
        
        return roomRepository.save(roomToUpdate);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}