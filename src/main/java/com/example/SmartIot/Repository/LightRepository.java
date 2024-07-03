package com.example.SmartIot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SmartIot.entity.Light;

public interface LightRepository extends JpaRepository<Light, Long> {

}
