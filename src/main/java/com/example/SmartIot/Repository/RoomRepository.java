package com.example.SmartIot.Repository;

import org.springframework.stereotype.Repository;

import com.example.SmartIot.entity.Room;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
