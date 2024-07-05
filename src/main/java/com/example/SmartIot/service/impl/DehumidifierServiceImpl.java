package com.example.SmartIot.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.SmartIot.entity.Dehumidifier;
import com.example.SmartIot.repository.DehumidifierRepository;
import com.example.SmartIot.service.ifs.DehumidifierService;

import jakarta.persistence.EntityNotFoundException;

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
    public Dehumidifier updateDehumidifier(Long id, Map<String, Object> updates) {
        Dehumidifier dehumidifier = dehumidifierRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dehumidifier not found"));
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Dehumidifier.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, dehumidifier, value);
        });
        return dehumidifierRepository.save(dehumidifier);
    }

    @Override
    public void deleteDehumidifier(Long id) {
        dehumidifierRepository.deleteById(id);
    }
}
