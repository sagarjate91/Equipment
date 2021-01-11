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
@Table(name = "ACCEPTANT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Acceptant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String equipmentId;
	@NotBlank
	private String equipmentDescription;
	@NotBlank
	private String equipmentRange;
	@NotBlank
	private String applicationRange;
	@NotBlank
	private String equipmentLeastCount;
	@NotBlank
	private String equipmentAccurency;
	@NotBlank
	private String parameterLowestTolerance;
	@NotBlank
	private String acceptantCriteria;
	@NotBlank
	private String equipmentUnit;
	@NotBlank
	private String referenceStandard;
	@NotBlank
	private String clauseNo;

}
