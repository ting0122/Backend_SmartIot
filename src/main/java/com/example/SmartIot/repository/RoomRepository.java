package com.example.SmartIot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmartIot.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    List<Room> findByNameContaining(String name);

    List<Room> findByTypeContaining(String type);

    Room findByArea(String area);

    List<Room> findByType(String type);

    List<Room> findByNameContainingAndType(String name, String type);
    
    List<Room> findByNameContainingAndTypeAndStatus(String name, String type, Boolean status);
    
    List<Room> findByNameContainingAndStatus(String name, Boolean status);
    
    List<Room> findByTypeAndStatus(String type, Boolean status);
    
    List<Room> findByStatus(Boolean status);
}
