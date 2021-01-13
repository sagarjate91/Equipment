package com.measuring.equipment.common;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewEquipmentDTO {
	
	private long id;
	@NotBlank(message = "Please enter the Id and sn")
	private String equipmentId;
	@NotBlank(message = "Please enter the sn")
	private String equipmen_sn;
	@NotBlank(message = "Please enter the description")
	private String equipmentDescription;
	@NotBlank(message = "Please enter the leastCount")
	private String equipmentLeastCount;
	private String equipmentUnit;
	@NotBlank(message = "Please enter the name")
	private String equipmentManfacturerName;
	@NotBlank(message = "Please enter the createdBy")
	private String equipmentCreatedBy;
	@NotBlank(message = "Please enter the createdDate")
	private String equipmentCreatedDate;
	@NotBlank(message = "Please enter the createTime")
	private String equipmentCreatedTime;
	@NotBlank(message = "Please enter the reason for update")
	private String equipmentReasonForUpdate;
	@NotBlank(message = "Please enter the cal frequency")
	private String equipmentCalibrationFrequency;
	@NotBlank(message = "Please enter the type")
	private String equipmentType;

}
