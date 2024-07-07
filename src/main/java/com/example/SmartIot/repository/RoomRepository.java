package com.example.SmartIot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmartIot.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    List<Room> findByNameContaining(String name);

    List<Room> findByTypeContaining(String type);

    List<Room> findByAreaContaining(String area);

    List<Room> findByNameContainingAndType(String name, String type);

    List<Room> findByNameContainingAndArea(String name, String area);

    List<Room> findByNameContainingAndTypeAndArea(String name, String type, String area);

    List<Room> findByNameContainingAndTypeAndAreaAndStatus(String name, String type, String area, Boolean status);
    
    List<Room> findByNameContainingAndTypeAndStatus(String name, String type, Boolean status);
    
    List<Room> findByNameContainingAndAreaAndStatus(String name, String area, Boolean status);
    
    List<Room> findByNameContainingAndStatus(String name, Boolean status);
    
    List<Room> findByTypeAndStatus(String type, Boolean status);
    
    List<Room> findByAreaAndStatus(String area, Boolean status);
    
    List<Room> findByStatus(Boolean status);
}
