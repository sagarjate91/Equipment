package com.measuring.equipment.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.measuring.equipment.common.EquipmentDTO;
import com.measuring.equipment.model.Equipment;
import com.measuring.equipment.model.IssueEquipment;
import com.measuring.equipment.model.Uequipment;
import com.measuring.equipment.repository.EquipmentRepository;
import com.measuring.equipment.repository.UequipmentRepository;
import com.measuring.equipment.services.ConstantService;
import com.measuring.equipment.services.ReportService;
import com.measuring.equipment.utility.FileUploadUtility;
import com.measuring.equipment.utility.Units;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/measuring/equipment/customer")
public class EquipmentController {

	@Autowired
	EquipmentRepository erepo;
	
	@Autowired
	UequipmentRepository UequipmentRepo;
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("/report")
	public void exportReport(HttpServletResponse response) throws JRException, IOException{
		reportService.exportReport(response);
	}
	
	@GetMapping("/customer-home.htm")
	public String customerHome(Model model, @ModelAttribute("message") String message) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "New Customer");
		model.addAttribute("userClickHome", true);
		return "page";
	}

	@GetMapping("/new-equipment.htm")
	public String equipment(Model model, @ModelAttribute("message") String message) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "New Customer");
		model.addAttribute("userClickNewEquipment", true);
		model.addAttribute("equipmentUnits", Units.units());
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-add");
		model.addAttribute(ConstantService.COMMAND, new EquipmentDTO());
		if (message != null) {
			model.addAttribute(ConstantService.MESSAGE, message + "");
		}
		return "page";
	}
	
	@GetMapping("/update-equipment.htm")
	public String equipmentUpdate(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Update Equipment");
		model.addAttribute("userClickUpdateEquipment", true);
		model.addAttribute(ConstantService.COMMAND, new EquipmentDTO());
		return "page";
	}
	
	@GetMapping("/issue-equipment.htm")
	public String issueEquipmentUpdate(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Issue Equipment");
		model.addAttribute("userClickIssueEquipment", true);
		model.addAttribute(ConstantService.COMMAND, new IssueEquipment());
		return "page";
	}
	
	@GetMapping("/acceptant-criteria.htm")
	public String issueAcceptantCriteria(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Acceptant Criteria");
		model.addAttribute("userClickAcceptantEquipment", true);
		model.addAttribute(ConstantService.COMMAND, new IssueEquipment());
		return "page";
	}
	
	@GetMapping("/history-card.htm")
	public String issueHistoryCard(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "History Card");
		model.addAttribute("userClickUpdateEquipment", true);
		model.addAttribute(ConstantService.COMMAND, new IssueEquipment());
		return "page";
	}
	
	@GetMapping("/list-laboratory.htm")
	public String issueListApproved(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Approved List");
		model.addAttribute("userClickUpdateEquipment", true);
		model.addAttribute(ConstantService.COMMAND, new IssueEquipment());
		return "page";
	}
	

	@GetMapping("/{id}/update")
	public String showSingleEquipment(@PathVariable long id, Model model) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Update Equipment");
		model.addAttribute("userClickNewEquipment", true);
		model.addAttribute("equipmentUnits", Units.units());
		model.addAttribute("userClickUpdate", true);
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-update");
		EquipmentDTO equipmentDTO=new EquipmentDTO();
		Equipment equipment=erepo.findById(id).orElse(null);
		if(equipment==null){
			throw new NullPointerException();
		}
		PropertyUtils.copyProperties(equipmentDTO,equipment);
		String e[]=equipment.getEquipmentId().split("_");
		equipmentDTO.setEquipmentId(e[0]);
		equipmentDTO.setEquipmen_sn(e[1]);
		model.addAttribute(ConstantService.COMMAND,equipmentDTO);
		return "page";
	}

	@GetMapping("/{id}/issue/update")
	public String showSingleEquipmentIssue(@PathVariable long id, Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Issue Equipment");
		model.addAttribute("userClickIssueEquipment", true);
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-issue");
		
		Equipment equipment=erepo.findById(id).orElse(null);
		IssueEquipment issueEquipment=new IssueEquipment();
		issueEquipment.setEquipmentId(equipment.getEquipmentId());
		issueEquipment.setEquipmentDescription(equipment.getEquipmentDescription());
		issueEquipment.setEquipmentCreatedBy(equipment.getEquipmentCreatedBy());
		issueEquipment.setEquipmentCreatedDate(equipment.getEquipmentCreatedDate());
		issueEquipment.setEquipmentCreatedTime(equipment.getEquipmentCreatedTime());
		//issueEquipment.setEquipmentDecisionOurRemark(equipment.getEquipmentDecisionOurRemark());
		//issueEquipment.setNotesValues(equipment.getNotesValues());
		model.addAttribute(ConstantService.COMMAND,issueEquipment);
		return "page";
	}

	@PostMapping("/equipment-add")
	public String equipmentAdd(@ModelAttribute("command") EquipmentDTO equipmentDTO, Model model,
			RedirectAttributes redirectAttributes) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		Equipment equipment=new Equipment();
		PropertyUtils.copyProperties(equipment, equipmentDTO);
		System.out.println(equipment);
		
		equipment.setEquipmentId(equipment.getEquipmentId()+"_"+equipment.getEquipmen_sn());
		erepo.save(equipment);
		redirectAttributes.addFlashAttribute(ConstantService.MESSAGE, "Equipment added successfully....!!!");
		return "redirect:/measuring/equipment/customer/new-equipment.htm";
	}
	
	@RequestMapping("/equipment-update")
	public String equipmentUpdate(@ModelAttribute("command") EquipmentDTO equipmentDTO, Model model,
								  RedirectAttributes redirectAttributes) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		Equipment equipment=new Equipment();
		Uequipment uequipment=new Uequipment();
		PropertyUtils.copyProperties(equipment, equipmentDTO);
		PropertyUtils.copyProperties(uequipment, equipmentDTO);
		
		System.out.println(equipment+"\t"+uequipment);
		uequipment.setEquipment(equipment);
		
		if(!equipmentDTO.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadProductDetails(equipmentDTO.getFile(),equipmentDTO);
		}
		//erepo.saveAndFlush(equipment);
		UequipmentRepo.save(uequipment);
		redirectAttributes.addFlashAttribute(ConstantService.MESSAGE, "Equipment updated successfully....!!!");
		return "redirect:/measuring/equipment/customer/new-equipment.htm";
	}
	

	
}
