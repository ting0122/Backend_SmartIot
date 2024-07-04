package com.example.SmartIot.vo;

import jakarta.validation.constraints.NotBlank;

public class RoomReq {
    
    @NotBlank(message = "Room name is mandatory")
    private String name;

    @NotBlank(message = "area is mandatory")
    private String area;//room

    private String type;
    
    //constructor
    public RoomReq() {
    }

    public RoomReq(@NotBlank(message = "Room name is mandatory") String name, String area, String type) {
        this.name = name;
        this.area = area;
        this.type = type;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
