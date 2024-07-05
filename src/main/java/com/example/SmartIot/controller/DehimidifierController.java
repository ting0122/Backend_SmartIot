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

    //獲取所有除濕機
    @GetMapping
    public List<Dehumidifier> getAllDehumidifiers() {
        return dehumidifierService.getAllDehumidifiers();
    }

    //獲取特定除濕機
    @GetMapping("/{id}")
    public Dehumidifier getDehumidifier(@PathVariable Long id) {
        return dehumidifierService.getDehumidifierById(id);
    }

    //新增或更新除濕機
    @PostMapping
    public Dehumidifier createDehumidifier(@RequestBody Dehumidifier dehumidifier) {
        //save 方法會判定有無id決定創建或修改
        return dehumidifierService.saveDehumidifier(dehumidifier);
    }

    //刪除除濕機
    @DeleteMapping("/{id}")
    public void deleteDehumidifier(@PathVariable Long id) {
        dehumidifierService.deleteDehumidifier(id);
    }
}
