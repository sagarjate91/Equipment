package com.measuring.equipment.common;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EquipmentDTO {
	
	private long id;
	private String equipmentId;
	private String equipmen_sn;
	private String equipmentDescription;
	private String equipmentLeastCount;
	private String equipmentUnit;
	private String equipmentManfacturerName;
	private String equipmentCreatedBy;
	private String equipmentCreatedDate;
	private String equipmentCreatedTime;
	private String equipmentReasonForUpdate;
	
	private String equipmentCalibrationFrequency;
	private String equipmentCalibrationLaboratory;
	private String equipmentCalibrationCertificateNo;
	private String equipmentCalibrationCertificateName;
	private String equipmentCalibrationResults;
	private String equipmentCalibrationUnit;
	private String equipmentAcceptanceCriteria;
	private String equipmentAcceptanceCriteriaUnit;
	private String equipmentDecisionOurRemark;
	private String equipmentLocation;
	private String equipmentCalibrationDate;
	private String equipmentCalibrationExpiryDate;
	private String equipmentType;
	private String notesValues;
	
	private MultipartFile file;

}
