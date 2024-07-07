package com.example.SmartIot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmartIot.entity.History;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>{

    List<History> findByDeviceId(Long deviceId);
    List<History> findByEventType(String eventType);

}
