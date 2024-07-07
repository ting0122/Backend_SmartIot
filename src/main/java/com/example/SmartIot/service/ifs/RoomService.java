package com.example.SmartIot.service.ifs;

import com.example.SmartIot.entity.Room;
import com.example.SmartIot.vo.RoomReq;

import jakarta.validation.Valid;

import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();

    Room getRoomById(Long id);

    List<Room> searchRooms(String name, String type, String area, Boolean status);

    Room createRoom(@Valid RoomReq roomReq);

    void deleteRoom(Long id);
}
