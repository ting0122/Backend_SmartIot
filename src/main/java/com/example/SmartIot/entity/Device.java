package com.example.SmartIot.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


//Jpa instance
@Entity
//this entity mapped to device table , default is class name
@Table(name = "device")
public class Device {
    
    //primary key
    @Id
    //primary key auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private Boolean status;
    private Timestamp time;

    //many device for one room
    @ManyToOne(fetch = FetchType.LAZY)
    //foreign key = room_id
    @JoinColumn(name = "room_id")
    private Room roomId;


    //constructor
    public Device() {
    }


    public Device(Long id, String name, String type, Boolean status, Timestamp time, Room roomId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.time = time;
        this.roomId = roomId;
    }

    //getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return this.time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Room getRoom() {
        return this.roomId;
    }

    public void setRoom(Room roomId) {
        this.roomId = roomId;
    }

}
