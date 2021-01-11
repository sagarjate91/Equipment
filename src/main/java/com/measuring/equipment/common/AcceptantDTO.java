package com.measuring.equipment.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AcceptantDTO {
	
	private long id;
	private String equipmentId;
	private String equipmentDescription;
	private String equipmentRange;
	private String applicationRange;
	private String equipmentLeastCount;
	private String equipmentAccurency;
	private String parameterLowestTolerance;
	private String acceptantCriteria;
	private String equipmentUnit;
	private String referenceStandard;
	private String clauseNo;

}
