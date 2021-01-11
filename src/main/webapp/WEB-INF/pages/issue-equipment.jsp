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
						<h3 class="card-title">Issue Equipment</h3>

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
								class="form-control" placeholder="Enter the equipment Id" />
							<sf:input type="hidden" path="id" id="id" class="form-control"
								readonly="true" />
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
							<label for="equipmentLeastCount">FROM LOCATION:</label>
							<sf:input path="fromLocation" id="fromLocation"
								class="form-control" placeholder="Enter the from Location"></sf:input>
							<sf:errors path="fromLocation" cssClass="help-block" element="em" />

						</div>

						<div class="form-group">
							<label for=toIssueLocation class="col-md-4 control-label"><span
								class="text-uppercase">To Issue Location: </span></label>
							<sf:input path="toIssueLocation" id="toIssueLocation"
								class="form-control" placeholder="Enter the to Location"></sf:input>
							<sf:errors path="toIssueLocation" cssClass="help-block"
								element="em" />

						</div>

						<div class="form-group">
							<label for="issueDate" class="col-md-4 control-label">ISSUE/RECEIVED
								DATE: </label>
							<sf:input path="issueDate" id="issueDate" class="form-control"
								placeholder="xxxxxxxx" />
							<sf:errors path="issueDate" cssClass="help-block" element="em" />
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
								<sf:input path="equipmentCreatedTime" id="equipmentCreatedTime"
									class="form-control" placeholder="Enter the created time"></sf:input>
								<sf:errors path="equipmentCreatedTime" cssClass="help-block"
									element="em" />

							</div>
						</div>

						<div class="form-group">
							<label for=equipmentDecisionOurRemark
								class="col-md-4 control-label"><span
								class="text-uppercase">Decision/Remark:</span> </label>
							<div class="col-md-8">
								<sf:input path="equipmentDecisionOurRemark"
									id="equipmentDecisionOurRemark" class="form-control"
									placeholder="Enter the decisionOur Remark"></sf:input>
								<sf:errors path="equipmentDecisionOurRemark"
									cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label for=equipmentCalibrationExpiryDate
								class="col-md-4 control-label"><span
								class="text-uppercase">Calibration Expiry Date: </span></label>
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
								class="text-uppercase">Note: </span></label>
							<div class="col-md-8">
								<sf:textarea path="notesValues" id="notesValues"
									class="form-control" placeholder="Enter the note"></sf:textarea>
								<sf:errors path="notesValues" cssClass="help-block" element="em" />
							</div>
						</div>


					</div>
					<!-- /.card-body -->
				</div>
				<!-- /.card -->
			</div>
			<!-- /.card -->
		</div>
		
		<div class="row">
			<div class="col-12">




				<input type="submit" value="Issue Equipment" class="btn btn-success">





			</div>
		</div>
	</section>
	<!-- /.content -->

</sf:form>
