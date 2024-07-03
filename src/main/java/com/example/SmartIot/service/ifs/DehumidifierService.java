package com.example.SmartIot.service.ifs;

import java.util.List;

import com.example.SmartIot.entity.Dehumidifier;

public interface DehumidifierService {

    List<Dehumidifier> getAllDehumidifiers();

    Dehumidifier getDehumidifierById(Long id);

    Dehumidifier saveDehumidifier(Dehumidifier dehumidifier);

    void deleteDehumidifier(Long id);
}
