package com.measuring.equipment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.measuring.equipment.services.ConstantService;

@Controller
@RequestMapping("/measuring/equipment/admin")
public class AdminController {

	@GetMapping({ "/adminHome.htm" })
	public String adminHome(Model model, @ModelAttribute("message") String message) {
		model.addAttribute(ConstantService.PROJECT_NAME, ConstantService.TITLE);
		model.addAttribute("userClickAdminHome", true);
		model.addAttribute(ConstantService.TITLE, "Admin Home");
		if (message != null) {
			model.addAttribute(ConstantService.MESSAGE, message + "");
		}
		return "page";
	}

}
