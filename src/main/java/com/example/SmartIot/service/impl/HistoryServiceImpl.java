package com.example.SmartIot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SmartIot.entity.History;
import com.example.SmartIot.repository.HistoryRepository;
import com.example.SmartIot.service.ifs.HistoryService;
import java.util.List;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> getAllHistories() {
        return historyRepository.findAll();
    }

    @Override
    public List<History> getHistoriesByDeviceId(Long deviceId) {
        return historyRepository.findByDeviceId(deviceId);
    }

    @Override
    public List<History> getHistoriesByEventType(String eventType) {
        return historyRepository.findByEventType(eventType);
    }

    @Override
    public History createHistory(History history) {
        return historyRepository.save(history);
    }

}
