package com.example.SmartIot.vo;

import java.sql.Timestamp;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DeviceReq {
    
    @NotBlank(message = "Device name is mandatory")
    private String name;

    @NotBlank(message = "Device type is mandatory")
    private String type;

    @NotNull(message = "Device status is mandatory")
    private Boolean status;

    @NotNull(message = "Device time is mandatory")
    private Timestamp time;

    @Nullable
    private Long roomId;

    //constructor
    public DeviceReq() {
    }

    public DeviceReq(@NotBlank(message = "Device name is mandatory") String name,
            @NotBlank(message = "Device type is mandatory") String type,
            @NotNull(message = "Device status is mandatory") Boolean status,
            @NotNull(message = "Device time is mandatory") Timestamp time,
            Long roomId) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.time = time;
        this.roomId = roomId;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

}
