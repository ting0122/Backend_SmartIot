package com.example.SmartIot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SmartIot.entity.Dehumidifier;
import com.example.SmartIot.service.ifs.DehumidifierService;

@CrossOrigin
@RestController
@RequestMapping("/dehumidifiers")
public class DehumidifierController {
    
    @Autowired
    private DehumidifierService dehumidifierService;

    // 获取所有除湿机
    @GetMapping
    public List<Dehumidifier> getAllDehumidifiers() {
        return dehumidifierService.getAllDehumidifiers();
    }

    // 获取特定除湿机
    @GetMapping("/{id}")
    public Dehumidifier getDehumidifier(@PathVariable("id") Long id) {
        return dehumidifierService.getDehumidifierById(id);
    }

    // 新增或修改除湿机
    @PostMapping
    public ResponseEntity<?> saveDehumidifier(@RequestBody Dehumidifier dehumidifier) {
        // save 方法会判定有无id决定创建或修改
        return dehumidifierService.saveDehumidifier(dehumidifier);
    }

    // 部分更新除湿机
    @PatchMapping("/{id}")
    public ResponseEntity<?> patchDehumidifier(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        return dehumidifierService.patchDehumidifier(id, updates);
    }

    // 删除除湿机
    @DeleteMapping("/{id}")
    public void deleteDehumidifier(@PathVariable("id") Long id) {
        dehumidifierService.deleteDehumidifier(id);
    }
}
