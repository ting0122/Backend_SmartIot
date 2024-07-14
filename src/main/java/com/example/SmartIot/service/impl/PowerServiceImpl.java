package com.example.SmartIot.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import com.example.SmartIot.entity.Device;
import com.example.SmartIot.entity.History;
import com.example.SmartIot.entity.Room;
import com.example.SmartIot.repository.DeviceRepository;
import com.example.SmartIot.repository.HistoryRepository;
import com.example.SmartIot.repository.RoomRepository;
import com.example.SmartIot.service.ifs.PowerService;

import jakarta.transaction.Transactional;

@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private RoomRepository roomRepository;

    //特定設備特定日期的使用時間
    @Override
    @Transactional
    public double calculateDeviceUsageTime(Long deviceId, LocalDate date) {

        //起始時間和結束時間
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);
        //查看歷史紀錄
        List<History> histories = historyRepository.findByDeviceIdAndEventTypeAndEventTimeBetween(
                deviceId, "設備開關", startOfDay, endOfDay);

        //總使用時間
        double totalUsageTime = 0;
        //最後一次開啟的時間,用來計算每次開啟和關閉的時長
        LocalDateTime lastOnTime = null;
        //計算時長
        for (History history : histories) {
            if (history.getDetail().get("status").equals("開")) {
                lastOnTime = history.getEventTime();
            } else if (history.getDetail().get("status").equals("關") && lastOnTime != null) {
                Duration duration = Duration.between(lastOnTime, history.getEventTime());
                //累積總使用時長
                totalUsageTime += duration.toMinutes() / 60.0;
                lastOnTime = null;
            }
        }

        return totalUsageTime;
    }

    //計算特定房間特定日期的設備使用時間
    @Override
    @Transactional
    public double calculateRoomDailyPowerConsumption(Long roomId, LocalDate date) {

        //找房間內所有電器
        List<Device> devices = deviceRepository.findByRoomId(roomId);

        //總設備使用時長
        double totalUsageTime = 0;
        for (Device device : devices) {
            totalUsageTime += calculateDeviceUsageTime(device.getId(), date);
        }

        return totalUsageTime;
    }

    //所有房間加總的設備使用時長
    @Override
    @Transactional
    public List<Map<String, Object>> calculateTotalDailyPowerConsumption(LocalDate date) {
        
        //尋找所有房間
        List<Room> rooms = roomRepository.findAll();

        //每個房間的情況
        List<Map<String, Object>> totalDailyConsumption = new ArrayList<>();
        for (Room room : rooms) {
            double roomConsumption = calculateRoomDailyPowerConsumption(room.getId(), date);
            Map<String, Object> consumptionData = new HashMap<>();
            consumptionData.put("roomId", room.getId());
            consumptionData.put("roomName", room.getName());
            consumptionData.put("date", date);
            consumptionData.put("consumption", roomConsumption);
            totalDailyConsumption.add(consumptionData);
        }

        return totalDailyConsumption;
    }

    //特定年月的使用狀況
    @Override
    @Transactional
    public Map<String, Double> calculateMonthlyPowerConsumption(int year, int month) {

        //月份的開始和結束時間
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate startOfMonth = yearMonth.atDay(1);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();

        //每一天的使用情況
        Map<String, Double> monthlyConsumption = new HashMap<>();
        for (LocalDate date = startOfMonth; !date.isAfter(endOfMonth); date = date.plusDays(1)) {
            double dailyConsumption = calculateTotalDailyPowerConsumption(date).stream()
                    .mapToDouble(entry -> (Double) entry.get("consumption"))
                    .sum();
            monthlyConsumption.put(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), dailyConsumption);
        }

        return monthlyConsumption;
    }
}
