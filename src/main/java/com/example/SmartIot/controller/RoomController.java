package com.example.SmartIot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartIot.entity.Room;
import com.example.SmartIot.service.ifs.RoomService;
import com.example.SmartIot.vo.RoomReq;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room createRoom(@RequestBody @Valid RoomReq roomReq) {
        return roomService.createRoom(roomReq);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody @Valid RoomReq roomReq) {
        return roomService.updateRoom(id, roomReq);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

}
