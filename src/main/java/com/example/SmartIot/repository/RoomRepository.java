package com.example.SmartIot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SmartIot.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    List<Room> findByNameContaining(String name);

    List<Room> findByTypeContaining(String type);

    List<Room> findByAreaContaining(String area);

    @Query("SELECT r FROM Room r WHERE r.name = :name AND r.type = :type")
    List<Room> findByNameContainingAndType(@Param("name") String name, @Param("type") String type);

    @Query("SELECT r FROM Room r WHERE r.name LIKE %:name% AND r.area = :area")
    List<Room> findByNameContainingAndArea(@Param("name") String name, @Param("area") String area);

    List<Room> findByNameContainingAndTypeAndArea(String name, String type, String area);
}
