package com.example.SmartIot.service.impl;

import com.example.SmartIot.constant.AirConditionerConstants.Mode;
import com.example.SmartIot.constant.AirConditionerConstants.FanSpeed;
import com.example.SmartIot.constant.AirConditionerResponseMessage;
import com.example.SmartIot.entity.AirConditioner;
import com.example.SmartIot.repository.AirConditionerRepository;
import com.example.SmartIot.service.ifs.AirConditionerService;
import com.example.SmartIot.vo.AirConditionerReq;
import com.example.SmartIot.vo.AirConditionerRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirConditionerServiceImpl implements AirConditionerService {

    @Autowired
    private AirConditionerRepository airConditionerRepository;

    @Override
    public AirConditionerRes getStatus(Long id) {
        // 查找指定ID的空調
        Optional<AirConditioner> acOptional = airConditionerRepository.findById(id);
        if (acOptional.isPresent()) {
            // 如果找到，轉換為回應對象並返回
            return convertToRes(acOptional.get());
        }
        throw new RuntimeException(AirConditionerResponseMessage.NOT_FOUND.getMessage());
    }

    @Override
    public AirConditionerRes updateStatus(AirConditionerReq req) {
        // 查找指定ID的空調
        Optional<AirConditioner> acOptional = airConditionerRepository.findById(req.getId());
        if (acOptional.isPresent()) {
            AirConditioner ac = acOptional.get();
            // 更新空調的各項設置
            ac.setTarget_temp(req.getTargetTemp());
            ac.setMode(req.getMode());
            ac.setFanSpeed(req.getFanSpeed());
            ac.getDevice().setStatus(req.isOn());

            // 保存更新後的空調並返回結果
            AirConditioner updatedAc = airConditionerRepository.save(ac);
            return convertToRes(updatedAc);
        }
        throw new RuntimeException(AirConditionerResponseMessage.NOT_FOUND.getMessage());
    }

    @Override
    public AirConditionerRes turnOn(Long id) {
        // 查找指定ID的空調
        Optional<AirConditioner> acOptional = airConditionerRepository.findById(id);
        if (acOptional.isPresent()) {
            AirConditioner ac = acOptional.get();
            // 打開空調
            ac.getDevice().setStatus(true);
            // 保存更新並返回結果
            AirConditioner updatedAc = airConditionerRepository.save(ac);
            return convertToRes(updatedAc);
        }
        throw new RuntimeException(AirConditionerResponseMessage.NOT_FOUND.getMessage());
    }

    @Override
    public AirConditionerRes turnOff(Long id) {
        // 查找指定ID的空調
        Optional<AirConditioner> acOptional = airConditionerRepository.findById(id);
        if (acOptional.isPresent()) {
            AirConditioner ac = acOptional.get();
            // 關閉空調
            ac.getDevice().setStatus(false);
            // 保存更新並返回結果
            AirConditioner updatedAc = airConditionerRepository.save(ac);
            return convertToRes(updatedAc);
        }
        throw new RuntimeException(AirConditionerResponseMessage.NOT_FOUND.getMessage());
    }

    @Override
    public AirConditionerRes setTemperature(Long id, Double temperature) {
        Optional<AirConditioner> acOptional = airConditionerRepository.findById(id);
        if (acOptional.isPresent()) {
            AirConditioner ac = acOptional.get();
            // 設置目標溫度
            ac.setTarget_temp(temperature);
            // 保存更新並返回結果
            AirConditioner updatedAc = airConditionerRepository.save(ac);
            return convertToRes(updatedAc);
        }
        throw new RuntimeException(AirConditionerResponseMessage.NOT_FOUND.getMessage());
    }

    @Override
    public AirConditionerRes setMode(Long id, Mode mode) {
        Optional<AirConditioner> acOptional = airConditionerRepository.findById(id);
        if (acOptional.isPresent()) {
            AirConditioner ac = acOptional.get();
            // 設置冷氣模式
            ac.setMode(mode);
            // 保存更新並返回結果
            AirConditioner updatedAc = airConditionerRepository.save(ac);
            return convertToRes(updatedAc);
        }
        throw new RuntimeException(AirConditionerResponseMessage.NOT_FOUND.getMessage());
    }

    @Override
    public AirConditionerRes setFanSpeed(Long id, FanSpeed fanSpeed) {
        Optional<AirConditioner> acOptional = airConditionerRepository.findById(id);
        if (acOptional.isPresent()) {
            AirConditioner ac = acOptional.get();
            // 設置風速
            ac.setFanSpeed(fanSpeed);
            AirConditioner updatedAc = airConditionerRepository.save(ac);
            return convertToRes(updatedAc);
        }
        throw new RuntimeException(AirConditionerResponseMessage.NOT_FOUND.getMessage());
    }

    private AirConditionerRes convertToRes(AirConditioner airConditioner) {
        // 創建一個新的 AirConditionerRes 對象來存儲轉換後的數據
        AirConditionerRes res = new AirConditionerRes();

        // 設置空調的唯一標識符
        res.setId(airConditioner.getId());

        // 設置空調的開關狀態，這裡通過 Device 對象獲取
        res.setOn(airConditioner.getDevice().getStatus());

        // 設置當前溫度
        res.setCurrentTemp(airConditioner.getCurrent_temp());

        // 設置目標溫度
        res.setTargetTemp(airConditioner.getTarget_temp());

        // 設置運行模式（如製冷、製熱等）
        res.setMode(airConditioner.getMode());

        // 設置風速
        res.setFanSpeed(airConditioner.getFanSpeed());

        return res;
    }
}