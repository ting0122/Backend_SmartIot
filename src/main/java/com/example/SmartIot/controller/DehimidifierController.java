package com.example.SmartIot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartIot.entity.Dehumidifier;
import com.example.SmartIot.service.ifs.DehumidifierService;

@RestController
@RequestMapping("/dehumidifiers")
public class DehimidifierController {
    
    @Autowired
    private DehumidifierService dehumidifierService;

    @GetMapping
    public List<Dehumidifier> getAllDehumidifiers() {
        return dehumidifierService.getAllDehumidifiers();
    }

    @GetMapping("/{id}")
    public Dehumidifier getDehumidifier(@PathVariable Long id) {
        return dehumidifierService.getDehumidifierById(id);
    }

    @PostMapping
    public Dehumidifier createDehumidifier(@RequestBody Dehumidifier dehumidifier) {
        return dehumidifierService.saveDehumidifier(dehumidifier);
    }

    @DeleteMapping("/{id}")
    public void deleteDehumidifier(@PathVariable Long id) {
        dehumidifierService.deleteDehumidifier(id);
    }
}
