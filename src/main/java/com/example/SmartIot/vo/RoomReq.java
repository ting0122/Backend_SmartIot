package com.example.SmartIot.vo;

import jakarta.validation.constraints.NotBlank;

public class RoomReq {
    
    @NotBlank(message = "Room name is mandatory")
    private String name;

    private String area;
    private String description;
    
    //constructor
    public RoomReq() {
    }

    public RoomReq(@NotBlank(message = "Room name is mandatory") String name, String area, String description) {
        this.name = name;
        this.area = area;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
