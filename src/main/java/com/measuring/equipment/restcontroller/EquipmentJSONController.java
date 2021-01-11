package com.measuring.equipment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.measuring.equipment.model.Equipment;
import com.measuring.equipment.repository.EquipmentRepository;
import com.measuring.equipment.services.ConstantService;

@RestController
@RequestMapping(ConstantService.USER)
public class EquipmentJSONController {
	
	@Autowired
	EquipmentRepository erepo;
	
	@GetMapping("/all/equipment")
	public List<Equipment> getAllEquipment(){
		return erepo.findAll();
	}
	
}
