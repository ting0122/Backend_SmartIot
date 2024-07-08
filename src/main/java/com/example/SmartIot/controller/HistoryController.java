package com.example.SmartIot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import com.example.SmartIot.entity.History;
import com.example.SmartIot.service.ifs.HistoryService;

import java.util.UUID;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public List<History> getAllHistories() {
        return historyService.getAllHistories();
    }

    @GetMapping("/{id}")
    public List<History> getHistoriesByDeviceId(@PathVariable("id") Long id) {
        return historyService.getHistoriesByDeviceId(id);
    }

    @GetMapping("/search")
    public List<History> getHistoriesByEventType(@RequestParam(name = "type",required = false) String eventType) {
        return historyService.getHistoriesByEventType(eventType);
    }

    @PostMapping
    public ResponseEntity<History> createHistory(@RequestBody History history) {
        try {
            // Set default values if not provided
            if (history.getEventTime() == null) {
                history.setEventTime(LocalDateTime.now());
            }
            if (history.getEventId() == null || history.getEventId().isEmpty()) {
                history.setEventId(UUID.randomUUID().toString());
            }

            History savedHistory = historyService.createHistory(history);
            return new ResponseEntity<>(savedHistory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}