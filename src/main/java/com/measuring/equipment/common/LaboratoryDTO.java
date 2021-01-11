package com.measuring.equipment.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LaboratoryDTO {
	
	private Long id;
	private String laboratoryName;
	private String address;
	private String contactNumber;
	private String emailId;
	private String calibrationScope;
	private String scopeCopy;
	private String certificationDetails;
	private String certificationNo;
	private String certificationCopy;
	private String certificattionDate;
	private String expiryDate;
	private String note;
	private String reminderOneMonthBeforeExpiryDate;

}
