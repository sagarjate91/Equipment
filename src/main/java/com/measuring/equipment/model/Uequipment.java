package com.measuring.equipment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "UEQUIPMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Uequipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uID;
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
	private String equipmentCalibrationExpiryDate;
	private String equipmentType;
	private String notesValues;
	
	@OneToOne
	Equipment equipment;

}
