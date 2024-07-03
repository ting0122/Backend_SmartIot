package com.example.SmartIot.repository;

import com.example.SmartIot.entity.AirConditioner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirConditionerRepository extends JpaRepository<AirConditioner, Long> {
}