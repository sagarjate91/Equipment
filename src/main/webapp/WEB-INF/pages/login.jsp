 <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
 
 
 <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Sign in to start your session</p>

       <sf:form action="${contextRoot}/${action}" modelAttribute="command" method="POST" class="form-horizontal" id="loginForm">

        <div class="input-group mb-3">
             <sf:input path="email" id="email" class="form-control" placeholder="Email" />
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
        <div class="row">
         
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block">Sign In</button>
          </div>
          <!-- /.col -->
        </div>
      </sf:form>


      <p class="mb-0">
        <a href="signup.htm" class="text-center">Register a new membership</a>
      </p>
    </div>
    <!-- /.login-card-body -->
    
    </div>