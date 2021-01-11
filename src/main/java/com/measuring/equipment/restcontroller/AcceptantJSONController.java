package com.measuring.equipment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.measuring.equipment.model.Acceptant;
import com.measuring.equipment.repository.AcceptantRepository;
import com.measuring.equipment.services.ConstantService;

@RestController
@RequestMapping(ConstantService.USER)
public class AcceptantJSONController {
	
	@Autowired
	AcceptantRepository acceptantRepository;
	
	@GetMapping("/all/acceptant")
	public List<Acceptant> getAcceptant(){
		return acceptantRepository.findAll();
	}

}
