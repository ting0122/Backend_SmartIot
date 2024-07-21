package com.example.SmartIot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.SmartIot.constant.AirConditionerConstants.FanSpeed;
import com.example.SmartIot.constant.AirConditionerConstants.Mode;
import com.example.SmartIot.entity.AirConditioner;

@Transactional
public interface AirConditionerRepository extends JpaRepository<AirConditioner, Long> {

    AirConditioner findByDeviceId(Long id);

    @Modifying(clearAutomatically=true)
    @Query(value="UPDATE device as d, ac "+
        "SET d.status = ?2, d.time = now(), "+
        "ac.current_temp = ?3, ac.target_temp = ?4, ac.fan_speed = ?5, ac.mode = ?6 "+
        "WHERE d.id = ac.id AND d.id = ?1", nativeQuery = true)
    public void updateData(Long id, boolean status, Double current_temp, Double target_temp, String fan_speed, String mode);
}