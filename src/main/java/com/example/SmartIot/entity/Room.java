package com.example.SmartIot.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String area;
    private String description;

    //one room can include mutiple devices
    //mappedBy : attribute room in the device class is owner
    //it wont create columns, just for define the relation ship
    @OneToMany(mappedBy = "roomId")
    private Set<Device> devices;


    //constructor
    public Room() {
    }


    public Room(Long id, String name, String area, String description, Set<Device> devices) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.description = description;
        this.devices = devices;
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

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Device> getDevices() {
        return this.devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

}
