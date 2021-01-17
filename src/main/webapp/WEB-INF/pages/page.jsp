<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css1" value="/plugins/fontawesome-free/css" />
<spring:url var="css2" value="/plugins/tempusdominus-bootstrap-4/css" />
<spring:url var="css3" value="/plugins/icheck-bootstrap" />
<spring:url var="css4" value="/plugins/jqvmap" />
<spring:url var="css5" value="/dist/css" />
<spring:url var="css6" value="/plugins/overlayScrollbars/css" />
<spring:url var="css7" value="/plugins/daterangepicker" />
<spring:url var="css8" value="/plugins/summernote" />

<spring:url var="css9" value="https://cdn.datatables.net/1.10.22/css" />
<spring:url var="img" value="/dist/img" />
<spring:url var="js1" value="/plugins/bootstrap/js" />
<spring:url var="js2" value="/plugins/chart.js" />
<spring:url var="js3" value="/plugins/sparklines" />
<spring:url var="js4" value="/plugins/jqvmap" />
<spring:url var="js5" value="/plugins/jqvmap/maps" />
<spring:url var="js6" value="/plugins/jquery-knob" />
<spring:url var="js7" value="/plugins/moment" />
<spring:url var="js8" value="/plugins/daterangepicker" />
<spring:url var="js9" value="/plugins/tempusdominus-bootstrap-4/js" />
<spring:url var="js10" value="/plugins/summernote" />
<spring:url var="js11" value="/plugins/overlayScrollbars/js" />
<spring:url var="js12" value="/dist/js" />
<spring:url var="js13" value="/dist/js/pages" />
<spring:url var="js14" value="/plugins/jquery" />
<spring:url var="js15" value="/plugins/jquery-ui" />
<spring:url var="js16" value="https://code.jquery.com" />
<spring:url var="js17" value="https://cdn.datatables.net/1.10.22/js" />

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>${title}</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${css1}/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="${css2}/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${css3}/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="${css4}/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${css5}/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="${css6}/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="${css7}/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="${css8}/summernote-bs4.css">
  
  <link rel="stylesheet" href="${css9}/jquery.dataTables.min.css">
  
  <link rel="stylesheet" href="${css5}/mycss.css">

  <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

 
  <script>
  
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
	window.userID='${sessionScope.role}'
	
</script>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Navbar -->
  <%@include file="./contents/navbar.jsp"%>

    <!-- SEARCH FORM -->
     <%@include file="./contents/search-form.jsp"%>

    <!-- Right navbar links -->
    <%@include file="./contents/right-navbar.jsp"%>
    
          
    <%@include file="./contents/notification.jsp"%>
      
      
  <!-- Main Sidebar Container -->
 <%@include file="./contents/main-sidebar.jsp"%>
 
 
 
    <!-- Sidebar -->
    <%@include file="./contents/sidebar.jsp"%>

      <!-- Sidebar Menu -->
      
       <%@include file="./contents/sidebar-menu.jsp"%>
      
      
    <!-- Content Wrapper. Contains page content -->
  
    <%@include file="./contents/content-header.jsp"%>
  
    <!-- /.content-header -->

    <!-- Main content -->
    
    <section class="content">
      <div class="container-fluid">
  
     <c:if test="${not empty message}">
             		<script>
                                           swal('${message}', {icon: 'success'});
                                          </script>
          </c:if>

    
   <%--  <%@include file="dashboard.jsp"%>
    --%> 
    <c:if test="${sessionScope.role==null}">

				<c:if test="${userClickHome==true}">
					<%@ include file="index.jsp"%>
				</c:if>

				<c:if test="${userClickUser==true or userClickAdmin==true}">
					<%@ include file="login.jsp"%>
				</c:if>

				<c:if test="${userClickRegister==true}">
					<%@ include file="sign-up.jsp"%>
				</c:if>

			</c:if>

			<c:if test="${sessionScope.role=='ADMIN'}">

				<c:if test="${userClickAdminHome==true}">
					<%@ include file="admin-home.jsp"%>
				</c:if>

			</c:if>

			<c:if test="${sessionScope.role=='CUSTOMER'}">
			
			  <c:if test="${userClickHome==true}">
            				<%@ include file="dashboard.jsp" %>
            			</c:if>

				<c:if test="${userClickNewEquipment==true}">
					<%@ include file="new-customer-equipment.jsp"%>
				</c:if>

				<c:if test="${userClickUpdateEquipment==true}">
					<%@ include file="update-customer-equipment.jsp"%>
				</c:if>

				<c:if
					test="${userClickIssueEquipment==true}">
					<%@ include file="issue-equipment.jsp"%>
				</c:if>

				<c:if test="${userClickHistoryEquipment==true}">
                    <%@ include file="update-customer-equipment.jsp"%>
				</c:if>

                <c:if test="${userClickAcceptant==true}">
					<%@ include file="acceptant.jsp"%>
				</c:if>

				<c:if test="${userClickAcceptantCriteria==true}">
					<%@ include file="acceptant-criteria.jsp"%>
				</c:if>

				<c:if test="${userClickLaboratory==true}">
					<%@ include file="laboratory.jsp"%>
				</c:if>


				<c:if test="${userClickLaboratoryList==true}">
					<%@ include file="approved-laboratory.jsp"%>
				</c:if>

			</c:if>

    
    
               
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2020-2021 <a href="http://adminlte.io">Our Company Name</a>.</strong>
    All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
      <b>Version</b> 3.0.5
    </div>
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${js14}/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="${js15}/jquery-ui.min.js"></script>

<script src="${js16}/jquery-3.5.1.js"></script>
<script src="${js17}/jquery.dataTables.min.js"></script>
<script src="${js12}/myapp.js"></script>
<script src="${js12}/bootbox.min.js"></script>

<!-- Bootstrap 4 -->
<script src="${js1}/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="${js2}/Chart.min.js"></script>
<!-- Sparkline -->
<script src="${js3}/sparkline.js"></script>
<!-- JQVMap -->
<!-- jQuery Knob Chart -->
<script src="${js6}/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="${js7}/moment.min.js"></script>
<script src="${js8}/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="${js9}/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="${js10}/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="${js11}/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="${js12}/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="${js13}/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${js12}/demo.js"></script>

 
 	
</body>
</html>
