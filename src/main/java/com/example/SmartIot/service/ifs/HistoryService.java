package com.example.SmartIot.service.ifs;

import com.example.SmartIot.entity.History;
import java.util.List;

public interface HistoryService {

    List<History> getAllHistories();
    List<History> getHistoriesByDeviceId(Long deviceId);
    List<History> getHistoriesByEventType(String eventType);
    History createHistory(History history);
}
