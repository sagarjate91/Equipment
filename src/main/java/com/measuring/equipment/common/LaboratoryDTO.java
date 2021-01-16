package com.measuring.equipment.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LaboratoryDTO {
	
	private Long id;
	@NotBlank(message = "Please enter the laboratoryName")
	private String laboratoryName;
	@NotBlank(message = "Please enter the address")
	private String address;
	@NotBlank(message = "Please enter the contactNumber")
	private String contactNumber;
	@NotBlank(message = "Please enter the emailId")
	private String emailId;
	@NotBlank(message = "Please enter the calibrationScope")
	private String calibrationScope;
	@NotBlank(message = "Please enter the scopeCopy")
	private String scopeCopy;
	@NotBlank(message = "Please enter the certificationDetails")
	private String certificationDetails;
	@NotBlank(message = "Please enter the certificationNo")
	private String certificationNo;
	@NotBlank(message = "Please enter the certificationCopy")
	private String certificationCopy;
	@NotBlank(message = "Please enter the certificattionDate")
	private String certificattionDate;
	@NotBlank(message = "Please enter the expiryDate")
	private String expiryDate;
	@NotBlank(message = "Please enter the note")
	private String note;
	@NotBlank(message = "Please enter the reminderOneMonthBeforeExpiryDate")
	private String reminderOneMonthBeforeExpiryDate;

}
