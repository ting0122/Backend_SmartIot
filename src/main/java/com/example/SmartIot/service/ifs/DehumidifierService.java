package com.example.SmartIot.service.ifs;

import java.util.List;

import java.util.Map;

import com.example.SmartIot.entity.Dehumidifier;

public interface DehumidifierService {

    List<Dehumidifier> getAllDehumidifiers();

    Dehumidifier getDehumidifierById(Long id);

    Dehumidifier saveDehumidifier(Dehumidifier dehumidifier);

    Dehumidifier updateDehumidifier(Long id, Map<String, Object> updates);

    void deleteDehumidifier(Long id);
}
