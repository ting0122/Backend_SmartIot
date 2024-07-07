package com.example.SmartIot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.SmartIot.entity.Device;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{

    List<Device> findByNameContaining(String name);

    List<Device> findByTypeContaining(String type);

    List<Device> findByStatus(Boolean status);

    @Query("SELECT d FROM Device d WHERE d.name = :name AND d.type = :type")
    List<Device> findByNameContainingAndType(@Param("name") String name, @Param("type") String type);

    @Query("SELECT d FROM Device d WHERE d.name LIKE %:name% AND d.status = :status")
    List<Device> findByNameContainingAndStatus(@Param("name") String name, @Param("status") Boolean status);

    List<Device> findByNameContainingAndTypeAndStatus(String name, String type, Boolean status);
}
