package com.measuring.equipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.measuring.equipment.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>{

}
