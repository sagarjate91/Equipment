<nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      
      <c:if test="${sessionScope.role=='CUSTOMER'}">
      
      <li class="nav-item d-none d-sm-inline-block">
        <a href="${contextRoot}/measuring/equipment/customer/customer-home.htm" class="nav-link">Home</a>
      </li>
      
      </c:if>
      
      <c:if test="${sessionScope.role=='ADMIN'}">
      
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Home</a>
      </li>
      
      </c:if>
      
       <li class="nav-item d-none d-sm-inline-block">
        <a href="${contextRoot}/measuring/equipment/logout" class="nav-link">Logout</a>
      </li>
     
    </ul>