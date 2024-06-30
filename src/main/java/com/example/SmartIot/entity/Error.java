package com.example.SmartIot.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "error")
public class Error {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate timestamp;

    //Large Object for store JSON
    //for example : CLOB = Long text , BLOB = Pics,videos,etc.
    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    //constructor
    public Error() {
    }


    public Error(Long id, LocalDate timestamp, String description, Device device) {
        this.id = id;
        this.timestamp = timestamp;
        this.description = description;
        this.device = device;
    }

    //getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }


}
