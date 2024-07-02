package com.example.SmartIot.service.ifs;

import java.util.List;

import com.example.SmartIot.entity.Device;
import com.example.SmartIot.vo.DeviceReq;

import jakarta.validation.Valid;

public interface DeviceService {

    //搜尋全部設備
    List<Device> getAllDevices();

    //搜尋特定設備
    Device getDeviceById(Long id);

    //新增設備
    Device createDevice(DeviceReq deviceReq);

    //更新設備
    Device updateDevice(Long id, @Valid DeviceReq deviceReq);

    //刪除設備
    void deleteDevice(Long id);
}
