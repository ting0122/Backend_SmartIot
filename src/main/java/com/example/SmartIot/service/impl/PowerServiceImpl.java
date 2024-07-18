package com.example.SmartIot.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
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

    //特定設備特定日期的用電量
    @Override
    @Transactional
    public double calculateDevicePowerConsumption(Long deviceId, LocalDate date) {

        //起始時間和結束時間
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);
        //查看歷史紀錄
        List<History> histories = historyRepository.findByDeviceIdAndEventTypeAndEventTimeBetween(
                deviceId, "設備開關", startOfDay, endOfDay);

        //總使用電量
        double totalPowerConsumption = 0;
        //最後一次開啟的時間,用來計算每次開啟和關閉的時長
        LocalDateTime lastOnTime = null;
        //找尋該設備
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new IllegalArgumentException("設備未找到"));

        //計算時長
        for (History history : histories) {
            if (history.getDetail().get("status").equals("開")) {
                lastOnTime = history.getEventTime();
            } else if (history.getDetail().get("status").equals("關") && lastOnTime != null) {
                Duration duration = Duration.between(lastOnTime, history.getEventTime());
                //累積總使用時間 * 功率
                totalPowerConsumption += (duration.toMinutes()/60.0) * device.getPowerConsumptionRate();
                lastOnTime = null;
            }
        }

        return totalPowerConsumption;
    }

    //計算特定房間特定日期的設備消耗電量
    @Override
    @Transactional
    public double calculateRoomDailyPowerConsumption(Long roomId, LocalDate date) {

        //找房間內所有電器
        List<Device> devices = deviceRepository.findByRoom_Id(roomId);

        //全設備耗電量
        double totalConsumption = 0;
        for (Device device : devices) {
            totalConsumption += calculateDevicePowerConsumption(device.getId(), date);
        }

        return totalConsumption;
    }

    @Override
    @Transactional
    public Map<String, Double> calculateRoomMonthlyPowerConsumption(Long roomId, int year, int month) {
        Map<String, Double> monthlyConsumption = new LinkedHashMap<>();

        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate startOfMonth = yearMonth.atDay(1);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();

        for (LocalDate date = startOfMonth; !date.isAfter(endOfMonth); date = date.plusDays(1)) {
            double dailyConsumption = calculateRoomDailyPowerConsumption(roomId, date);
            monthlyConsumption.put(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), dailyConsumption);
        }

        return monthlyConsumption;
    }

    //所有房間加總的耗電量
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

    //特定年月的耗電量
    @Override
    @Transactional
    public Map<String, Double> calculateMonthlyPowerConsumption(int year, int month) {

        //月份的開始和結束時間
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate startOfMonth = yearMonth.atDay(1);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();

        //為了讓他排序好日期
        Map<String, Double> monthlyConsumption = new LinkedHashMap<>();

        //每一天的使用情況
        for (LocalDate date = startOfMonth; !date.isAfter(endOfMonth); date = date.plusDays(1)) {
            double dailyConsumption = calculateTotalDailyPowerConsumption(date).stream()
                    .mapToDouble(entry -> (Double) entry.get("consumption"))
                    .sum();
            monthlyConsumption.put(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), dailyConsumption);
        }

        // 排序
        monthlyConsumption = monthlyConsumption.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        return monthlyConsumption;
    }

    //整年每個月的耗電量
    @Override
    @Transactional
    public Map<String, Double> calculateYearlyPowerConsumption(int year) {
        Map<String, Double> yearlyConsumption = new LinkedHashMap<>();

        for (int month = 1; month <= 12; month++) {
            double monthlyConsumption = calculateMonthlyPowerConsumption(year, month).values().stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
            yearlyConsumption.put(String.format("%d-%02d", year, month), monthlyConsumption);
        }

        return yearlyConsumption;
    }
}
