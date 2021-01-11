package com.measuring.equipment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "LABORATORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Laboratory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
