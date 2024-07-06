package com.example.SmartIot.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


//該實體映射到名為 device 的資料表
@Entity
@Table(name = "device")
public class Device {
    
    // 主鍵
    @Id
    // 主鍵自動增長
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private Boolean status = false;
    private Timestamp time = Timestamp.valueOf(LocalDateTime.now());

    // 多個設備對應到一個房間(等到您實際訪問 room 屬性時才加載room實體)
    @ManyToOne(fetch = FetchType.LAZY)
    // 外鍵設置為 room_id
    @JoinColumn(name = "room_id")
    //序列化時，Device 不會序列化其 room 屬性，從而避免無限遞迴
    @JsonBackReference
    private Room room;


    //constructor
    public Device() {
    }


    public Device(Long id, String name, String type, Boolean status, Timestamp time, Room room) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.time = time;
        this.room = room;
    }

    // 在實體被保存到數據庫之前調用
    @PrePersist
    protected void onCreate() {
        if (this.status == null) {
            this.status = false; // 如果 status 是 null，則設置為 false
        }
        if (this.time == null) {
            this.time = Timestamp.valueOf(LocalDateTime.now()); // 如果 time 是 null，則設置為當前時間
        }
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
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
