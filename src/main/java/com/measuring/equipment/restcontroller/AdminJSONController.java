package com.measuring.equipment.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.measuring.equipment.model.Customer;
import com.measuring.equipment.services.ConstantService;
import com.measuring.equipment.services.CustomerService;

@RestController
@RequestMapping(ConstantService.ADMIN)
public class AdminJSONController {

	@Autowired
	CustomerService service;

	@GetMapping("/all/Users")
	public List<Customer> users() {
		return service.users();
	}
	
	@PutMapping("/manage/{id}/activation")
    public String getUserUpdate(@PathVariable int id){
        return service.getUserUpdate(id);
    }

}
