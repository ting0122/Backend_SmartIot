package com.example.SmartIot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartIot.entity.Room;
import com.example.SmartIot.service.ifs.RoomService;
import com.example.SmartIot.vo.RoomReq;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/rooms")
public class RoomController {
    
    @Autowired
    private RoomService roomService;

    //獲取所有房間
    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    //獲取特定房間,  PathVariable 把url裡的{id} 放到 方法裡的參數Long id上
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable("id") Long id) {
        return roomService.getRoomById(id);
    }

    //創建或更新房間, RequestBody將JSON轉為RoomReq, Valid要求驗證entity裡 寫的驗證註解,如:NotBlank
    @PostMapping
    public Room createRoom(@RequestBody @Valid RoomReq roomReq) {
        return roomService.createRoom(roomReq);
    }

    //刪除房間
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable("id") Long id) {
        roomService.deleteRoom(id);
    }

}
