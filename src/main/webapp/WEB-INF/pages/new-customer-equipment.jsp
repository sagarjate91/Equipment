<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form action="${contextRoot}/${action}" modelAttribute="command"
	method="POST" enctype="multipart/form-data" class="form-horizontal"
	id="userForm">

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-6">
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">New Equipment Creation</h3>

						<div class="card-tools">
							<button type="button" class="btn btn-tool"
								data-card-widget="collapse" data-toggle="tooltip"
								title="Collapse">
								<i class="fas fa-minus"></i>
							</button>
						</div>
					</div>
					<div class="card-body">
						<div class="form-group">
							<label for="inputName">EQUIPMENT ID</label>
							<sf:input path="equipmentId" id="equipmentId"
								placeholder="Equipment Id" class="form-control"/>
							<sf:input path="equipmen_sn" id="equipmen_sn" class="form-control" placeholder="SN" />
							<sf:hidden path="id" id="id" readonly="true" />
							<sf:errors path="equipmentId" cssClass="help-block" element="em" />
						</div>

						<div class="form-group">
							<label for="equipmentDescription">DESCRIPTION</label>
							<sf:input path="equipmentDescription" id="equipmentDescription"
								class="form-control" placeholder="Enter the description" />
							<sf:errors path="equipmentDescription" cssClass="help-block"
								element="em" />

						</div>

						<div class="form-group">
							<label for="equipmentLeastCount">EQUIPMENT LEAST COUNT:</label>
							<sf:input path="equipmentLeastCount" id="equipmentLeastCount"
								class="form-control" placeholder="Enter the Least Count" />
							<sf:errors path="equipmentLeastCount" cssClass="help-block"
								element="em" />

						</div>

						<div class="form-group">
							<label for="inputStatus">EQUIPMENT UNIT:</label>
							<sf:select path="equipmentUnit"
								class="form-control custom-select">
								<sf:options items="${equipmentUnits}" />
							</sf:select>
						</div>

						<div class="form-group">
							<label for="equipmentManfacturerName">MANUFACTURER NAME:
							</label>
							<sf:input path="equipmentManfacturerName"
								id="equipmentManfacturerName" class="form-control"
								placeholder="Enter the manfacturer name" />
							<sf:errors path="equipmentManfacturerName" cssClass="help-block"
								element="em" />
						</div>

						<div class="form-group">
							<label for="equipmentCreatedBy" class="col-md-4 control-label">CREATED
								BY: </label>
							<div class="col-md-8">
								<sf:input path="equipmentCreatedBy" id="equipmentCreatedBy"
									class="form-control" placeholder="xxxxxxxxx" />
								<sf:errors path="equipmentCreatedBy" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label for="equipmentCreatedDate" class="col-md-4 control-label">CREATED
								DATE: </label>
							<div class="col-md-8">
								<sf:input path="equipmentCreatedDate" id="equipmentCreatedDate"
									class="form-control" placeholder="xxxxxxxx" />
								<sf:errors path="equipmentCreatedDate" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label for="equipmentCreatedTime" class="col-md-4 control-label">CREATED
								TIME: </label>
							<div class="col-md-8">
								<sf:input path="equipmentCreatedTime" id="equipmentCreatedTime1"
									class="form-control" placeholder="Enter the created time"></sf:input>
								<sf:errors path="equipmentCreatedTime" cssClass="help-block"
									element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="equipmentReasonForUpdate"
								class="col-md-4 control-label"> REASON FOR UPDATE: </label>
							<div class="col-md-8">
								<sf:textarea path="equipmentReasonForUpdate"
									id="equipmentReasonForUpdate" class="form-control"
									placeholder="Enter the reason for update"></sf:textarea>
								<sf:errors path="equipmentReasonForUpdate" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label for="equipmentCalibrationFrequency"
								class="col-md-4 control-label">CALIBRATION FREQUENCY: </label>
							<div class="col-md-8">
								<sf:input path="equipmentCalibrationFrequency"
									id="equipmentCalibrationFrequency" class="form-control"
									placeholder="Enter the calibration frequency"></sf:input>
								<sf:errors path="equipmentCalibrationFrequency"
									cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label for=equipmentType class="col-md-4 control-label"><span
								class="text-uppercase">Equipment Type</span> </label>
							<div class="col-md-8">
								<sf:input path="equipmentType" id="equipmentType"
									class="form-control" placeholder="Enter the equipment type"></sf:input>
								<sf:errors path="equipmentType" cssClass="help-block"
									element="em" />
							</div>
						</div>
						
						<c:if test="${userClickUpdate==true}">
						
						<div class="form-group">
								<label for="equipmentCalibrationLaboratory"
									class="col-md-4 control-label"><span
									class="text-uppercase">Calibration Laboratory:</span></label>
								<div class="col-md-8">
									<sf:input path="equipmentCalibrationLaboratory"
										id="equipmentCalibrationLaboratory" class="form-control"
										placeholder="Enter the calibration frequency"></sf:input>
									<sf:errors path="equipmentCalibrationLaboratory"
										cssClass="help-block" element="em" />
								</div>
							</div>
							
							</c:if>
						

					</div>
					<!-- /.card-body -->
				</div>
				<!-- /.card -->
			</div>
			<div class="col-md-6">
				<div class="card card-primary">
				
				<c:if test="${userClickUpdate==true}">
				
					<div class="card-body">

							
							<div class="form-group">
								<label for=equipmentCalibrationCertificateNo
									class="col-md-4 control-label"><span
									class="text-uppercase">Calibration Certificate No:</span></label>
								<div class="col-md-8">
									<sf:input path="equipmentCalibrationCertificateNo"
										id="equipmentCalibrationCertificateNo" class="form-control"
										placeholder="Enter the Calibration Certificate No"></sf:input>
									<sf:errors path="equipmentCalibrationCertificateNo"
										cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label for=file class="col-md-4 control-label"><span
									class="text-uppercase">Select Calibration Certificate:</span></label>
								<div class="col-md-8">
									<sf:input type="file" path="file" id="file"
										class="form-control"></sf:input>
									<sf:errors path="file" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label for=equipmentCalibrationResults
									class="col-md-4 control-label"><span
									class="text-uppercase">Calibration Results:</span></label>
								<div class="col-md-8">
									<sf:input path="equipmentCalibrationResults"
										id="equipmentCalibrationResults" class="form-control"
										placeholder="Enter the calibration results"></sf:input>
									<sf:errors path="equipmentCalibrationResults"
										cssClass="help-block" element="em" />
                                     <button id="id_equipmentCalibrationResults">Load Result</button>
								</div>
							</div>

							<div class="form-group">
								<label for=equipmentCalibrationUnit
									class="col-md-4 control-label"><span
									class="text-uppercase">Calibration Unit:</span></label>
								<div class="col-md-8">
									<sf:input path="equipmentCalibrationUnit"
										id="equipmentCalibrationUnit" class="form-control"
										placeholder="Enter the calibration unit"></sf:input>
									<sf:errors path="equipmentCalibrationUnit"
										cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label for=equipmentAcceptanceCriteria
									class="col-md-4 control-label"><span
									class="text-uppercase">Acceptance Criteria:</span></label>
								<div class="col-md-8">
									<sf:input path="equipmentAcceptanceCriteria"
										id="equipmentAcceptanceCriteria" class="form-control"
										placeholder="Enter the acceptance criteria"></sf:input>
									<sf:errors path="equipmentAcceptanceCriteria"
										cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label for=equipmentAcceptanceCriteriaUnit
									class="col-md-4 control-label"><span
									class="text-uppercase">Acceptance Criteria Unit:</span></label>
								<div class="col-md-8">
									<sf:input path="equipmentAcceptanceCriteriaUnit"
										id="equipmentAcceptanceCriteriaUnit" class="form-control"
										placeholder="Enter the acceptance criteria unit"></sf:input>
									<sf:errors path="equipmentAcceptanceCriteriaUnit"
										cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label for=equipmentDecisionOurRemark
									class="col-md-4 control-label"><span
									class="text-uppercase">Decision Our Remark:</span></label>
								<div class="col-md-8">
									<sf:input path="equipmentDecisionOurRemark"
										id="equipmentDecisionOurRemark" class="form-control"
										placeholder="Enter the decisionOur Remark"></sf:input>
									<sf:errors path="equipmentDecisionOurRemark"
										cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label for=equipmentLocation class="col-md-4 control-label"><span
									class="text-uppercase">Equipment Location:</span></label>
								<div class="col-md-8">
									<sf:input path="equipmentLocation" id="equipmentLocation"
										class="form-control" placeholder="Enter the location"></sf:input>
									<sf:errors path="equipmentLocation" cssClass="help-block"
										element="em" />
								</div>
							</div>

							<div class="form-group">
								<label for="equipmentCalibrationDate"
									class="col-md-4 control-label">CALIBRATION DATE: </label>
								<div class="col-md-8">
									<sf:input path="equipmentCalibrationDate"
										id="equipmentCalibrationDate" class="form-control"
										placeholder="xxxxxxxx" />
									<sf:errors path="equipmentCalibrationDate"
										cssClass="help-block" element="em" />
								</div>
							</div>


							<div class="form-group">
								<label for=equipmentCalibrationExpiryDate
									class="col-md-4 control-label"><span
									class="text-uppercase">Calibration Expiry Date:</span></label>
								<div class="col-md-8">
									<sf:input path="equipmentCalibrationExpiryDate"
										id="equipmentCalibrationExpiryDate" class="form-control"
										placeholder="Enter the calibration expiry date"></sf:input>
									<sf:errors path="equipmentCalibrationExpiryDate"
										cssClass="help-block" element="em" />
								</div>
							</div>



							<div class="form-group">
								<label for=notesValues class="col-md-4 control-label"><span
									class="text-uppercase">Note:</span></label>
								<div class="col-md-8">
									<sf:textarea path="notesValues" id="notesValues"
										class="form-control" placeholder="Enter the note"></sf:textarea>
									<sf:errors path="notesValues" cssClass="help-block"
										element="em" />
								</div>
							</div>

						</c:if>


					</div>
					<!-- /.card-body -->
				</div>
				<!-- /.card -->
			</div>
		</div>
		<div class="row">
			<div class="col-12">


				<c:if test="${userClickUpdate==true}">


					<input type="submit" value="Update Equipment"
						class="btn btn-success" />


				</c:if>

				<c:if test="${userClickUpdate==null}">

					<input type="submit" value="Create New Equipment"
						class="btn btn-success" />

				</c:if>

			</div>
		</div>
	</section>
	<!-- /.content -->

</sf:form>
