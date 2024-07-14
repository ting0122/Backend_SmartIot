package com.example.SmartIot.service.ifs;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface PowerService {

    //特定設備在特定日期的使用時間,以小時為單位
    double calculateDeviceUsageTime(Long deviceId, LocalDate date);

    //特定房間特定日期的總使用時間
    double calculateRoomDailyPowerConsumption(Long roomId, LocalDate date);

    //所有房間的特定日期使用時間
    List<Map<String, Object>> calculateTotalDailyPowerConsumption(LocalDate date);

    //特定年月使用時間
    Map<String, Double> calculateMonthlyPowerConsumption(int year, int month);
}
