package com.example.SmartIot.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.SmartIot.entity.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>{

    List<History> findByDeviceIdAndEventTypeAndEventTimeBetween(Long deviceId, String eventType, LocalDateTime startTime, LocalDateTime endTime);

}
