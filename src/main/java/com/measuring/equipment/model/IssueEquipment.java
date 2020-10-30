package com.measuring.equipment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ISSUE_EQUIPMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IssueEquipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String equipmentId;
	private String equipmentDescription;
	private String fromLocation;
	private String toIssueLocation;
	private String issueDate;
	private String equipmentCreatedBy;
	private String equipmentCreatedDate;
	private String equipmentCreatedTime;
	private String equipmentDecisionOurRemark;
	private String equipmentCalibrationExpiryDate;
	private String notesValues;
	

}
