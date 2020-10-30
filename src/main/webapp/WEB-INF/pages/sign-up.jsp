 <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>			
   
 <div class="card">
    <div class="card-body register-card-body">
      <p class="login-box-msg">Register a new membership</p>

      <sf:form action="${contextRoot}/${action}" modelAttribute="command" method="POST" enctype="multipart/form-data" class="form-horizontal" id="userForm">
       
        <div class="input-group mb-3">
           <sf:input path="firstName" id="firstName" class="form-control" placeholder="FirstName"/>
           <sf:errors path="firstName" cssClass="help-block" element="em"/>
       
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        
        
        <div class="input-group mb-3">
           <sf:input path="lastName" id="lastName" class="form-control" placeholder="LastName"/>
           <sf:errors path="lastName" cssClass="help-block" element="em"/>
      
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        
         <div class="input-group mb-3">
           <sf:input path="userName" id="userName" class="form-control" placeholder="UserName"/>
           <sf:errors path="userName" cssClass="help-block" element="em"/>
      
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        
        <div class="input-group mb-3">
           <sf:input path="email" id="email" class="form-control" placeholder="Email"/>
           <sf:errors path="email" cssClass="help-block" element="em"/> 
           <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
           <sf:input type="password" path="password" id="password" class="form-control" placeholder="Password"/>
           <sf:errors path="password" cssClass="help-block" element="em"/> 
         <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        
        <div class="input-group mb-3">
             <sf:input path="mobileNumber" id="mobileNumber" class="form-control" placeholder="Mobile Number"/>
           <sf:errors path="mobileNumber" cssClass="help-block" element="em"/>
       <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        
        <div class="input-group mb-3">
          <sf:input path="pinCode" id="pinCode" class="form-control" placeholder="Pincode"/>
           <sf:errors path="pinCode" cssClass="help-block" element="em"/>
        <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        
        <div class="input-group mb-3">
           <sf:textarea path="address" id="address" class="form-control" placeholder="Address"></sf:textarea>
           <sf:errors path="address" cssClass="help-block" element="em"/> 
            <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
            
            </div>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block">Register</button>
          </div>
          <!-- /.col -->
        </div>
       </sf:form>	


      <a href="login.htm" class="text-center">I already have a membership</a>
    </div>
    <!-- /.form-box -->
  </div><!-- /.card -->
