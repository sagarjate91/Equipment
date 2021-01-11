package com.measuring.equipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class EquipmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentApplication.class, args);
	}
	

}
