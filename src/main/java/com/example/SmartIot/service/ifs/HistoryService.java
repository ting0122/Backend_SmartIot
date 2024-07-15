package com.example.SmartIot.service.ifs;

import com.example.SmartIot.entity.History;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface HistoryService {

    List<History> getAllHistories();

    History createHistory(History history);

    List<History> getHistoriesByDeviceId(Long id);

    List<History> getHistoriesByEventType(String eventType);

    List<History> searchHistories(String deviceName, String deviceType, LocalDate date, String roomArea);

    //歷史紀錄搜尋欄位 日期、設備名稱、空間編號、設備類型
    
}
