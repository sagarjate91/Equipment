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
public class IssueEquipmentDTO {


    private long id;
    @NotBlank(message = "Please enter the Id")
    private String equipmentId;
    @NotBlank(message = "Please enter the description")
    private String equipmentDescription;
    @NotBlank(message = "Please enter the fromLocation")
    private String fromLocation;
    @NotBlank(message = "Please enter the toIssueLocation")
    private String toIssueLocation;
    @NotBlank(message = "Please enter the issueDate")
    private String issueDate;
    @NotBlank(message = "Please enter the equipmentCreatedBy")
    private String equipmentCreatedBy;
    @NotBlank(message = "Please enter the equipmentCreatedDate")
    private String equipmentCreatedDate;
    @NotBlank(message = "Please enter the equipmentCreatedTime")
    private String equipmentCreatedTime;
    @NotBlank(message = "Please enter the equipmentDecisionOurRemark")
    private String equipmentDecisionOurRemark;
    @NotBlank(message = "Please enter the equipmentCalibrationExpiryDate")
    private String equipmentCalibrationExpiryDate;
    @NotBlank(message = "Please enter the notesValues")
    private String notesValues;

}
