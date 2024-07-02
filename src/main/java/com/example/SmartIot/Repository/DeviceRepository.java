package com.example.SmartIot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmartIot.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{

}
