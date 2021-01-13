package com.measuring.equipment.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.measuring.equipment.common.LoginModel;
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

	@GetMapping({ "/login", "/customer.htm", "/login.htm", "/" })
	public String loginUser(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Customer Panel");
		model.addAttribute("userClickUser", true);
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/login-validate");
		model.addAttribute(ConstantService.COMMAND, new LoginModel());
		return "main";
	}

	@PostMapping("/login-validate")
	public String loginValidate(@ModelAttribute("command") @Valid LoginModel userModel, BindingResult bindingResult,
			HttpSession session, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
			model.addAttribute(ConstantService.TITLE, "Customer Panel");
			model.addAttribute("userClickUser", true);
			model.addAttribute(ConstantService.ACTION, "measuring/equipment/login-validate");
			return "main";

		}
		Customer customer = repo.findByEmail(userModel.getEmail());
		if (customer == null) {
			model.addAttribute(ConstantService.MESSAGE, "User does not exist");
			return URLServices.USER_URL;
		}
		if (!userModel.getPassword().trim().equals(customer.getPassword().trim())) {
			model.addAttribute(ConstantService.MESSAGE, "Password mismatch");
			return URLServices.USER_URL;
		}
		if (customer.getStatus() != 1) {
			model.addAttribute(ConstantService.MESSAGE, "Your Account not activated");
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
		if (customer.getEmail().equalsIgnoreCase("admin@gmail.com") && customer.getPassword().equalsIgnoreCase("123")) {
			addUserInSession(session, customer.getEmail(), ConstantService.ADMIN_ROLE);
			return "redirect:admin/adminHome.htm";
		} else {
			redirectAttributes.addFlashAttribute(ConstantService.MESSAGE,
					"Wrong Email and password,Please try new one");
			return "redirect:/measuring/equipment/admin.htm";
		}
	}

	@GetMapping({ "/signup.htm" })
	public String signup(Model model, @RequestParam(value = "message", required = false) String message) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Signup Panel");
		model.addAttribute("userClickRegister", true);
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/signup-add");
		model.addAttribute(ConstantService.COMMAND, new UserModel());
		// model.addAttribute("message", "User Already added,Please try new
		// one..!");
		return "main";
	}

	@PostMapping("/signup-add")
	public String user(@ModelAttribute("command") @Valid UserModel userModel, BindingResult bindingResult, Model model)
			throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

		if (bindingResult.hasErrors()) {
			model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
			model.addAttribute(ConstantService.TITLE, "Signup Panel");
			model.addAttribute("userClickRegister", true);
			model.addAttribute(ConstantService.ACTION, "measuring/equipment/signup-add");
			return "main";

		}

		if (repo.findByEmail(userModel.getEmail()) != null) {
			return "redirect:/measuring/equipment/signup.htm?message=User Already added,Please try new one..!";
		} else {
			Customer customer = new Customer();
			PropertyUtils.copyProperties(customer, userModel);
			repo.save(customer);
			model.addAttribute(ConstantService.MESSAGE, "User added successfully....!!!");
			return "redirect:/measuring/equipment/signup.htm?message=User added successfully....!!!";
		}

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
		model.addAttribute("userClickUser", true);
		return "redirect:/measuring/equipment/login";
	}
}
