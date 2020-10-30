package com.measuring.equipment.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.measuring.equipment.common.UserModel;
import com.measuring.equipment.model.Customer;
import com.measuring.equipment.repository.CustomerRepository;
import com.measuring.equipment.services.ConstantService;
import com.measuring.equipment.services.URLServices;

@Controller
@RequestMapping("/measuring/equipment")
public class HomeController {

	@Autowired
	CustomerRepository repo;
	
	@GetMapping({ "/", "/home.htm" ,""})
	private String index(Model model){
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Home Panel");
		return "main";
	}

	@GetMapping({ "/login", "/customer.htm" ,"/login.htm"})
	public String loginUser(Model model, @ModelAttribute("message") String message) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Customer Panel");
		model.addAttribute("userClickUser", true);
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/login-validate");
		model.addAttribute(ConstantService.COMMAND, new UserModel());
		if (message != null) {
			model.addAttribute(ConstantService.MESSAGE, message +"");
		}
		return "main";
	}

	@PostMapping("/login-validate")
	public String loginValidate(@Valid @ModelAttribute("command") UserModel userModel, HttpSession session,
			RedirectAttributes redirectAttribute, Model model) {

		Customer customer = repo.findByEmail(userModel.getEmail());
		if (customer == null) {
			redirectAttribute.addAttribute(ConstantService.MESSAGE, "User does not exist");
			return URLServices.USER_URL;
		}
		if (!userModel.getPassword().trim().equals(customer.getPassword().trim())) {
			redirectAttribute.addAttribute(ConstantService.MESSAGE, "Password mismatch");
			return URLServices.USER_URL;
		}
		if (customer.getStatus() != 1) {
			redirectAttribute.addAttribute(ConstantService.MESSAGE, "Your Account not activated");
			return URLServices.USER_URL;
		}
		addUserInSession(session, customer.getEmail(), ConstantService.USER_ROLE);
		// set the name and the id
		userModel.setId(customer.getId());
		session.setAttribute("userModel", userModel);
		session.setAttribute("userID", customer.getId());
		return "redirect:/measuring/equipment/customer/customer-home.htm";
	}

	@GetMapping("/error")
	public String error() {
		return "error.jsp";
	}

	@GetMapping({ "/signup.htm" })
	public String signup(Model model, @ModelAttribute("message") String message) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Signup Panel");
		model.addAttribute("userClickRegister", true);
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/signup-add");
		model.addAttribute(ConstantService.COMMAND, new UserModel());
		if (message != null) {
			model.addAttribute(ConstantService.MESSAGE, message + "");
		}
		return "main";
	}

	@GetMapping({ "/admin.htm" })
	public String adminUser(@ModelAttribute("message") String message, Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Admin Panel");
		model.addAttribute("userClickAdmin", true);
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/admin-validate");
		model.addAttribute(ConstantService.COMMAND, new UserModel());
		if (message != null) {
			model.addAttribute(ConstantService.MESSAGE, message);
		}
		return "main";
	}

	@PostMapping({ "/admin-validate" })
	public String adminValidate(@ModelAttribute("command") Customer customer, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) {
		if (customer.getEmail().equalsIgnoreCase("admin@gmail.com")
				&& customer.getPassword().equalsIgnoreCase("123")) {
			addUserInSession(session, customer.getEmail(), ConstantService.ADMIN_ROLE);
			return "redirect:admin/adminHome.htm";
		} else {
			redirectAttributes.addFlashAttribute(ConstantService.MESSAGE,
					"Wrong Email and password,Please try new one");
			return "redirect:/measuring/equipment/admin.htm";
		}
	}

	@PostMapping("/signup-add")
	public String user(@Valid @ModelAttribute("command") Customer customer, RedirectAttributes redirectAttributes) {
		if (repo.findByEmail(customer.getEmail()) != null) {
			redirectAttributes.addFlashAttribute("message", "User Already added,Please try new one..!");
		} else {
			repo.save(customer);
			redirectAttributes.addFlashAttribute(ConstantService.MESSAGE, "User added successfully....!!!");
		}
		return "redirect:/measuring/equipment/signup.htm";
	}

	public void addUserInSession(HttpSession session, String email, String role) {
		try {
			session.setAttribute("email", email);
			session.setAttribute("role", role);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("userClickHome", true);
		return "redirect:/measuring/equipment/";
	}
}
