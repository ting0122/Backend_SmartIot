package com.example.SmartIot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartIot.entity.Dehumidifier;
import com.example.SmartIot.repository.DehumidifierRepository;
import com.example.SmartIot.service.ifs.DehumidifierService;

@Service
public class DehumidifierServiceImpl implements DehumidifierService {
    
    @Autowired
    private DehumidifierRepository dehumidifierRepository;

    @Override
    public List<Dehumidifier> getAllDehumidifiers() {
        return dehumidifierRepository.findAll();
    }

    @Override
    public Dehumidifier getDehumidifierById(Long id) {
        return dehumidifierRepository.findById(id).orElse(null);
    }

    @Override
    public Dehumidifier saveDehumidifier(Dehumidifier dehumidifier) {
        return dehumidifierRepository.save(dehumidifier);
    }

    @Override
    public void deleteDehumidifier(Long id) {
        dehumidifierRepository.deleteById(id);
    }
}
