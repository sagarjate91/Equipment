package com.measuring.equipment.controller;

import java.lang.reflect.InvocationTargetException;

import javax.validation.Valid;

import com.measuring.equipment.common.*;
import com.measuring.equipment.repository.*;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.measuring.equipment.model.Acceptant;
import com.measuring.equipment.model.Equipment;
import com.measuring.equipment.model.IssueEquipment;
import com.measuring.equipment.model.Laboratory;
import com.measuring.equipment.model.Uequipment;
import com.measuring.equipment.services.ConstantService;
import com.measuring.equipment.utility.FileUploadUtility;
import com.measuring.equipment.utility.Units;

@Controller
@RequestMapping("/measuring/equipment/customer")
public class EquipmentController {

	@Autowired
	EquipmentRepository erepo;
	
	@Autowired
	UequipmentRepository UequipmentRepo;
	
	@Autowired
	AcceptantRepository acceptantRepository;
	
	@Autowired
	LaboratoryResponsitory laboratoryResponsitory;

	@Autowired
    IssueEquipmentRepository issueEquipmentRepository;
	
	@GetMapping("/customer-home.htm")
	public String equipmentCustomer(Model model, @ModelAttribute("message") String message) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Customer Home");
		model.addAttribute("userClickHome", true);
		return "page";
	}

    @GetMapping("/acceptant.htm")
    public String equipmentAcceptantPanel(Model model) {
        model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
        model.addAttribute(ConstantService.TITLE, "Acceptant Criteria");
        model.addAttribute("userClickAcceptant", true);
        model.addAttribute(ConstantService.COMMAND, new AcceptantDTO());
        return "page";
    }


	@GetMapping("/acceptant-criteria.htm")
	public String equipmentAcceptant(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Acceptant Criteria");
		model.addAttribute("userClickAcceptantCriteria", true);
		model.addAttribute("equipmentUnits", Units.units());
		model.addAttribute("active", "active");
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-acceptant-register");
		model.addAttribute(ConstantService.COMMAND, new AcceptantDTO());
		return "page";
	}
	
	@PostMapping("/equipment-acceptant-register")
	public String equipmentAcceptantAdd(Model model,@ModelAttribute("command") @Valid AcceptantDTO acceptantDTO,BindingResult bindingResult) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        if (bindingResult.hasErrors()) {
            model.addAttribute(ConstantService.TITLE, "Acceptant Criteria");
            model.addAttribute("userClickAcceptantCriteria", true);
            model.addAttribute("equipmentUnits", Units.units());
            model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-acceptant-register");
            return "page";
        }

	    Acceptant acceptant=new Acceptant();
		if(acceptantDTO==null)
			throw new NullPointerException();
		
		PropertyUtils.copyProperties(acceptant,acceptantDTO);
		acceptantRepository.saveAndFlush(acceptant);
		
		model.addAttribute(ConstantService.TITLE, "Acceptant Criteria");
		model.addAttribute("userClickAcceptantCriteria", true);
		model.addAttribute("equipmentUnits", Units.units());
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-acceptant-register");
		model.addAttribute(ConstantService.COMMAND, new AcceptantDTO());
		model.addAttribute(ConstantService.MESSAGE, "Acceptant added successfully");
		return "page";
	}
	
	@GetMapping("/{id}/acceptant-register")
	public String showSingleAcceptant(@PathVariable long id, Model model) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Acceptant Criteria");
		model.addAttribute("userClickAcceptantCriteria", true);
		model.addAttribute("equipmentUnits", Units.units());
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-acceptant-register");
		Acceptant acceptant=acceptantRepository.findById(id).orElse(null);
		AcceptantDTO acceptantDTO=new AcceptantDTO();
		PropertyUtils.copyProperties(acceptantDTO,acceptant);
		model.addAttribute(ConstantService.COMMAND,acceptantDTO);
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
		model.addAttribute(ConstantService.COMMAND, new IssueEquipmentDTO());
        model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-issue");
        return "page";
	}

    @PostMapping("/equipment-issue")
    public String issueEquipment(@ModelAttribute("command") @Valid IssueEquipmentDTO issueEquipmentDTO,BindingResult bindingResult,Model model) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{

        if (bindingResult.hasErrors()) {
            model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
            model.addAttribute(ConstantService.TITLE, "Issue Equipment");
            model.addAttribute("userClickIssueEquipment", true);
            model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-add");
            return "page";

        }

        IssueEquipment issueEquipment=new IssueEquipment();
        PropertyUtils.copyProperties(issueEquipment,issueEquipmentDTO);
        issueEquipmentRepository.saveAndFlush(issueEquipment);
        model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
        model.addAttribute(ConstantService.TITLE, "Issue Equipment");
        model.addAttribute("userClickIssueEquipment", true);
        model.addAttribute(ConstantService.MESSAGE, "Issue added successfully");
        model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-issue");
        model.addAttribute(ConstantService.COMMAND, new IssueEquipmentDTO());
        return "page";
    }

	@GetMapping("/history-card.htm")
	public String issueHistoryCard(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "History Card");
		model.addAttribute("userClickHistoryEquipment", true);
		return "page";
	}
	
	@GetMapping("/list-laboratory.htm")
	public String issueListApproved(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Approved List");
		model.addAttribute("userClickLaboratory", true);
		return "page";
	}
	
	@GetMapping("/laboratory.htm")
	public String issueListApprovedAdd(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Approved List");
		model.addAttribute("userClickLaboratoryList", true);
		model.addAttribute(ConstantService.COMMAND, new LaboratoryDTO());
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-approved-laboratory-add");
		return "page";
	}
	
	@PostMapping("/equipment-approved-laboratory-add")
	public String approvedLaboratory(Model model,@ModelAttribute("command") @Valid LaboratoryDTO laboratoryDTO,BindingResult bindingResult) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{

        if (bindingResult.hasErrors()) {
            model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
            model.addAttribute(ConstantService.TITLE, "Approved List");
            model.addAttribute("userClickLaboratoryList", true);
            model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-approved-laboratory-add");
            return "page";

        }

        Laboratory laboratory=new Laboratory();
		PropertyUtils.copyProperties(laboratory,laboratoryDTO);
		laboratoryResponsitory.saveAndFlush(laboratory);
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "Approved List");
		model.addAttribute("userClickLaboratoryList", true);
		model.addAttribute(ConstantService.COMMAND, new LaboratoryDTO());
		model.addAttribute(ConstantService.MESSAGE, "Laboratory added successfully");
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-approved-laboratory-add");
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

		Acceptant acceptant=acceptantRepository.findByEquipmentId(equipment.getEquipmentId());
		if(equipment==null){
			throw new NullPointerException();
		}
		PropertyUtils.copyProperties(equipmentDTO,equipment);
		equipmentDTO.setEquipmentAcceptanceCriteria(acceptant.getAcceptantCriteria());
		equipmentDTO.setEquipmentAcceptanceCriteriaUnit(acceptant.getEquipmentUnit());
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

	
	@GetMapping("/new-equipment.htm")
	public String equipment(Model model) {
		model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
		model.addAttribute(ConstantService.TITLE, "New Customer");
		model.addAttribute("userClickNewEquipment", true);
		model.addAttribute("equipmentUnits", Units.units());
		model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-add");
		model.addAttribute(ConstantService.COMMAND, new NewEquipmentDTO());
		return "page";
	}
	
	@PostMapping("/equipment-add")
	public String equipmentAdd(@ModelAttribute("command") @Valid NewEquipmentDTO equipmentDTO,BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (bindingResult.hasErrors()) {
			model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
			model.addAttribute(ConstantService.TITLE, "New Customer");
			model.addAttribute("userClickNewEquipment", true);
			model.addAttribute("equipmentUnits", Units.units());
			model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-add");
			return "page";

		}
		
		Equipment equipment=new Equipment();
		PropertyUtils.copyProperties(equipment, equipmentDTO);
		
		erepo.save(equipment);
		redirectAttributes.addFlashAttribute(ConstantService.MESSAGE, "Equipment added successfully....!!!");
		return "redirect:/measuring/equipment/customer/new-equipment.htm";
	}
	
	@RequestMapping("/equipment-update")
	public String equipmentUpdate(@ModelAttribute("command") @Valid EquipmentDTO equipmentDTO,BindingResult bindingResult, Model model) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (bindingResult.hasErrors()) {
			model.addAttribute(ConstantService.NAME, ConstantService.TITLE);
			model.addAttribute(ConstantService.TITLE, "Update Equipment");
			model.addAttribute("userClickNewEquipment", true);
			model.addAttribute("equipmentUnits", Units.units());
			model.addAttribute("userClickUpdate", true);
			model.addAttribute(ConstantService.ACTION, "measuring/equipment/customer/equipment-update");

			Acceptant acceptant=acceptantRepository.findByEquipmentId(equipmentDTO.getEquipmentId());
			if(equipmentDTO==null){
				throw new NullPointerException();
			}
			PropertyUtils.copyProperties(equipmentDTO,equipmentDTO);
			equipmentDTO.setEquipmentAcceptanceCriteria(acceptant.getAcceptantCriteria());
			equipmentDTO.setEquipmentAcceptanceCriteriaUnit(acceptant.getEquipmentUnit());
			model.addAttribute(ConstantService.COMMAND,equipmentDTO);
			return "page";

		}
		Equipment equipment=new Equipment();
		Uequipment uequipment=new Uequipment();
		PropertyUtils.copyProperties(equipment, equipmentDTO);
		PropertyUtils.copyProperties(uequipment, equipmentDTO);
		
		uequipment.setEquipment(equipment);
		
		if(!equipmentDTO.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadProductDetails(equipmentDTO.getFile(),equipmentDTO);
		}
		//erepo.saveAndFlush(equipment);
		UequipmentRepo.save(uequipment);
		return "redirect:/measuring/equipment/customer/new-equipment.htm";
	}
}
