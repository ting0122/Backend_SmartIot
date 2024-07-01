package com.example.SmartIot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {
    
    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }


}
