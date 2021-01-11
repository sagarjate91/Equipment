package com.measuring.equipment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "EQUIPMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Equipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String equipmentId;
	@Transient
	private String equipmen_sn;
	@NotBlank
	private String equipmentDescription;
	@NotBlank
	private String equipmentLeastCount;
	@NotBlank
	private String equipmentUnit;
	@NotBlank
	private String equipmentManfacturerName;
	@NotBlank
	private String equipmentCreatedBy;
	@NotBlank
	private String equipmentCreatedDate;
	@NotBlank
	private String equipmentCreatedTime;
	@NotBlank
	private String equipmentReasonForUpdate;
	@NotBlank
	private String equipmentCalibrationFrequency;
	@NotBlank
	private String equipmentType;
	
}
