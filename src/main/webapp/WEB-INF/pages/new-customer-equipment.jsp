<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>	
  <sf:form action="${contextRoot}/${action}" modelAttribute="command" method="POST" enctype="multipart/form-data" class="form-horizontal" id="userForm">
       
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-6">
          <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">New Equipment Creation</h3>
     
              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                  <i class="fas fa-minus"></i></button>
              </div>
            </div>
            <div class="card-body">
              <div class="form-group">
                <label for="inputName">EQUIPMENT ID</label>
                 <sf:input  path="equipmentId" id="equipmentId" placeholder="Equipment Id" />
                 <sf:input  path="equipmen_sn" id="equipmen_sn" placeholder="SN" />
                 <sf:hidden path="id" id="id" class="form-control" readonly="true" />
                 <sf:errors path="equipmentId" cssClass="help-block" element="em"/>
              </div>
              
              <div class="form-group">
                <label for="equipmentDescription">DESCRIPTION</label>
                <sf:input path="equipmentDescription" id="equipmentDescription" class="form-control" placeholder="Enter the description"/>
                <sf:errors path="equipmentDescription" cssClass="help-block" element="em"/>
         
              </div>
              
              <div class="form-group">
                <label for="equipmentLeastCount">EQUIPMENT LEAST COUNT:</label>
                 <sf:input path="equipmentLeastCount" id="equipmentLeastCount" class="form-control" placeholder="Enter the Least Count"/>
           		 <sf:errors path="equipmentLeastCount" cssClass="help-block" element="em"/>
       
              </div>
              
              <div class="form-group">
                <label for="inputStatus">EQUIPMENT UNIT:</label>
              		<sf:select path="equipmentUnit" class="form-control custom-select">
    				<sf:options items="${equipmentUnits}" />
				</sf:select>
              </div>
              
               <div class="form-group">
          <label for="equipmentManfacturerName" >MANUFACTURER NAME: </label>
           <sf:input path="equipmentManfacturerName" id="equipmentManfacturerName" class="form-control" placeholder="Enter the manfacturer name"/>
           <sf:errors path="equipmentManfacturerName" cssClass="help-block" element="em"/> 
         </div>
         
         <div class="form-group">
          <label for="equipmentCreatedBy" class="col-md-4 control-label">CREATED BY: </label>
          <div class="col-md-8">
           <sf:input path="equipmentCreatedBy" id="equipmentCreatedBy" class="form-control" placeholder="xxxxxxxxx"/>
           <sf:errors path="equipmentCreatedBy" cssClass="help-block" element="em"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="equipmentCreatedDate" class="col-md-4 control-label">CREATED DATE: </label>
          <div class="col-md-8">
           <sf:input path="equipmentCreatedDate" id="equipmentCreatedDate" class="form-control" placeholder="xxxxxxxx"/>
           <sf:errors path="equipmentCreatedDate" cssClass="help-block" element="em"/>
          </div>
         </div>
      
         <div class="form-group">
          <label for="equipmentCreatedTime" class="col-md-4 control-label">CREATED TIME: </label>
          <div class="col-md-8">
           <sf:input path="equipmentCreatedTime" id="equipmentCreatedTime1" class="form-control" placeholder="Enter the created time"></sf:input>
           <sf:errors path="equipmentCreatedTime" cssClass="help-block" element="em"/> 
          </div>
         </div>
              
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <div class="col-md-6">
          <div class="card card-primary">
            
            <div class="card-body">
              <div class="form-group">
                <label for="inputEstimatedBudget">Estimated budget</label>
                <input type="number" id="inputEstimatedBudget" class="form-control">
              </div>
              <div class="form-group">
                <label for="inputSpentBudget">Total amount spent</label>
                <input type="number" id="inputSpentBudget" class="form-control">
              </div>
              <div class="form-group">
                <label for="inputEstimatedDuration">Estimated project duration</label>
                <input type="number" id="inputEstimatedDuration" class="form-control">
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
      </div>
      <div class="row">
        <div class="col-12">
          <a href="#" class="btn btn-secondary">Cancel</a>
          <input type="submit" value="Create new Porject" class="btn btn-success float-right">
        </div>
      </div>
    </section>
    <!-- /.content -->
    
    </sf:form>	