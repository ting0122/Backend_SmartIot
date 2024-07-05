package com.example.SmartIot.simulator;

import com.example.SmartIot.entity.AirConditioner;
import com.example.SmartIot.repository.AirConditionerRepository;
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

    @Scheduled(fixedRate = 5000) // 每 5 秒更新一次
    public void simulateSignals() {
        List<AirConditioner> airConditioners = airConditionerRepository.findAll();

        for (AirConditioner ac : airConditioners) {
            if (ac.getDevice().getStatus()) { // 如果冷氣是開啟的
                // 根據模式更新溫度
                updateTemperature(ac);
            }

            // 模擬隨機的環境溫度變化
            simulateEnvironmentTemperature(ac);
            // 更新空調的狀態
            airConditionerRepository.save(ac);
        }
    }

    private void updateTemperature(AirConditioner ac) {
        double currentTemp = ac.getCurrent_temp();
        double targetTemp = ac.getTarget_temp();

        if (Math.abs(currentTemp - targetTemp) > 0.1) {
            // 根據模式調整溫度
            switch (ac.getMode()) {
                case COOL:
                    ac.setCurrent_temp(Math.max(currentTemp - 0.5, targetTemp));
                    break;
                case HEAT:
                    ac.setCurrent_temp(Math.min(currentTemp + 0.5, targetTemp));
                    break;
                case DRY:
                    ac.setCurrent_temp(Math.max(currentTemp - 0.2, targetTemp));
                    break;
                case FAN:
                    // 風扇模式不改變溫度
                    break;
                case AUTO:
                    if (currentTemp > targetTemp) {
                        ac.setCurrent_temp(Math.max(currentTemp - 0.5, targetTemp));
                    } else {
                        ac.setCurrent_temp(Math.min(currentTemp + 0.5, targetTemp));
                    }
                    break;
            }
        }
    }

    private void simulateEnvironmentTemperature(AirConditioner ac) {
        // 模擬環境溫度的微小變化
        double environmentalChange = (random.nextDouble() - 0.5) * 0.2; // -0.1 到 0.1 之間的隨機值
        ac.setCurrent_temp(ac.getCurrent_temp() + environmentalChange);
    }
}