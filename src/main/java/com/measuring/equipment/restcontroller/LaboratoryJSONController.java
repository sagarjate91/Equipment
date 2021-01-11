package com.measuring.equipment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.measuring.equipment.model.Laboratory;
import com.measuring.equipment.repository.LaboratoryResponsitory;
import com.measuring.equipment.services.ConstantService;

@RestController
@RequestMapping(ConstantService.USER)
public class LaboratoryJSONController {
	
	@Autowired
	LaboratoryResponsitory laboratoryResponsitory;
	
	@GetMapping("/all/laboratory")
	public List<Laboratory> getLaboratory(){
		return laboratoryResponsitory.findAll();
	}

}
