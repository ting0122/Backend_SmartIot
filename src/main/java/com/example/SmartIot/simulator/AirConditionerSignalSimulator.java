package com.example.SmartIot.simulator;

import com.example.SmartIot.entity.AirConditioner;
import com.example.SmartIot.repository.AirConditionerRepository;
import com.example.SmartIot.constant.AirConditionerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AirConditionerSignalSimulator {

    @Autowired
    private AirConditionerRepository airConditionerRepository;
    private Random random = new Random();

    @Scheduled(fixedRate = 5000) // 每5秒更新一次
    public void simulateSignals() {
        List<AirConditioner> airConditioners = airConditionerRepository.findAll();
        for (AirConditioner ac : airConditioners) {
            if (ac.getDevice().getStatus()) { // 如果空調機是開啟的
                // 更新溫度
                updateTemperature(ac);
            }
            // 模拟環境溫度的微小變化
            simulateEnvironmentTemperature(ac);
            // 更新空調機的狀態
            airConditionerRepository.save(ac);
        }
    }

    private void updateTemperature(AirConditioner ac) {
        double currentTemp = ac.getCurrent_temp();
        double targetTemp = ac.getTarget_temp();
        AirConditionerConstants.Mode mode = ac.getMode();
        AirConditionerConstants.FanSpeed fanSpeed = ac.getFanSpeed();

        // 根據模式和風速調整溫度
        double tempChange = calculateTempChange(currentTemp, targetTemp, mode, fanSpeed);
        ac.setCurrent_temp(currentTemp + tempChange);
    }

    private double calculateTempChange(double currentTemp, double targetTemp,
            AirConditionerConstants.Mode mode,
            AirConditionerConstants.FanSpeed fanSpeed) {
        double baseChange = 0.1; // 基溫變化率
        double fanSpeedMultiplier = getFanSpeedMultiplier(fanSpeed);

        switch (mode) {
            case COOL:
                return Math.max(-baseChange * fanSpeedMultiplier, targetTemp - currentTemp);
            case HEAT:
                return Math.min(baseChange * fanSpeedMultiplier, targetTemp - currentTemp);
            case DRY:
                return -baseChange * 0.5; // 除濕模式慢慢降溫
            case AUTO: 
                return Math.min(baseChange * fanSpeedMultiplier, 27 - currentTemp); // 自動模式慢慢調整成27度
            case FAN:
            default:
                return 0; // 風扇模式不改變溫度
        }
    }

    private double getFanSpeedMultiplier(AirConditionerConstants.FanSpeed fanSpeed) {
        switch (fanSpeed) {
            case LOW:
                return 1.0;
            case MEDIUM:
                return 1.5;
            case HIGH:
                return 2.0;
            case AUTO:
            default:
                return 1.5; // 自動風速假設為中等
        }
    }

    private void simulateEnvironmentTemperature(AirConditioner ac) {
        // 模擬環境溫度的微小變化
        double environmentalChange = (random.nextDouble() - 0.5) * 0.2; // -0.1 到 0.1 之間的隨機值
        double newTemp = ac.getCurrent_temp() + environmentalChange;
        // 確保溫度在合理範圍內，例如 10 到 40 度
        ac.setCurrent_temp(Math.max(10, Math.min(40, newTemp)));
    }

}