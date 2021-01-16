package com.measuring.equipment.common;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class AcceptantDTO {
	
	private long id;
	@NotBlank(message = "Please enter the equipmentId")
	private String equipmentId;
	@NotBlank(message = "Please enter the equipmentDescription")
	private String equipmentDescription;
	@NotBlank(message = "Please enter the equipmentRange")
	private String equipmentRange;
	@NotBlank(message = "Please enter the applicationRange")
	private String applicationRange;
	@NotBlank(message = "Please enter the equipmentLeastCount")
	private String equipmentLeastCount;
	@NotBlank(message = "Please enter the equipmentAccurency")
	private String equipmentAccurency;
	@NotBlank(message = "Please enter the parameterLowestTolerance")
	private String parameterLowestTolerance;
	@NotBlank(message = "Please enter the acceptantCriteria")
	private String acceptantCriteria;
	@NotBlank(message = "Please enter the equipmentUnit")
	private String equipmentUnit;
	@NotBlank(message = "Please enter the referenceStandard")
	private String referenceStandard;
	@NotBlank(message = "Please enter the clauseNo")
	private String clauseNo;

}
