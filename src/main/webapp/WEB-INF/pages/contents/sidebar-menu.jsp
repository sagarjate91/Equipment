<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<nav class="mt-2">
	<ul class="nav nav-pills nav-sidebar flex-column"
		data-widget="treeview" role="menu" data-accordion="false">
		<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->


		</li>

		<li class="nav-item has-treeview"><c:choose>
				<c:when
					test="${userClickNewEquipment==true || userClickUpdateEquipment==true || userClickIssueEquipment==true}">
					<a href="#" class="nav-link active"/>
				</c:when>

				<c:otherwise>.
      				<a href="#" class="nav-link"/>
				</c:otherwise>
			</c:choose> <i class="nav-icon fas fa-copy"></i>
			<p>
				Equipment <i class="fas fa-angle-left right"></i>

			</p> </a>
			<ul class="nav nav-treeview">
				<li class="nav-item"><a
					href="${contextRoot}/measuring/equipment/customer/new-equipment.htm"
					class="nav-link"> <i class="far fa-circle nav-icon"></i>
						<p>New Equipment Creation</p>
				</a></li>
				<li class="nav-item"><a
					href="${contextRoot}/measuring/equipment/customer/update-equipment.htm"
					class="nav-link"> <i class="far fa-circle nav-icon"></i>
						<p>Update Equipment</p>
				</a></li>
				<li class="nav-item"><a
					href="${contextRoot}/measuring/equipment/customer/issue-equipment.htm"
					class="nav-link"> <i class="far fa-circle nav-icon"></i>
						<p>Issue Equipment</p>
				</a></li>

			</ul></li>
		<li class="nav-item has-treeview"><c:choose>
				<c:when test="${userClickAcceptantEquipment==true}">
					<a href="#" class="nav-link active"/>
				</c:when>

				<c:otherwise>.
      				<a href="#" class="nav-link"/>
				</c:otherwise>
			</c:choose> 
			<i class="nav-icon fas fa-tree"></i>
			<p>
				Acceptant Criteria <i class="fas fa-angle-left right"></i>
			</p> </a>
			<ul class="nav nav-treeview">
				<li class="nav-item"><a
					href="${contextRoot}/measuring/equipment/customer/acceptant.htm"
					class="nav-link"> <i class="far fa-circle nav-icon"></i>
						<p>Acceptant Criteria</p>
				</a></li>


			</ul></li>

		<li class="nav-item has-treeview"><c:choose>
				<c:when test="${userClickHistoryEquipment==true}">
					<a href="#" class="nav-link active"/>
				</c:when>

				<c:otherwise>.
      				<a href="#" class="nav-link"/>
				</c:otherwise>
			</c:choose> <i class="nav-icon fas fa-edit"></i>
			<p>
				History <i class="fas fa-angle-left right"></i>
			</p> </a>
			<ul class="nav nav-treeview">
				<li class="nav-item"><a
					href="${contextRoot}/measuring/equipment/customer/history-card.htm"
					class="nav-link"> <i class="far fa-circle nav-icon"></i>
						<p>History Card</p>
				</a></li>

			</ul></li>

		<li class="nav-item has-treeview"><c:choose>
				<c:when test="${userClickLaboratory==true}">
					<a href="#" class="nav-link active"/>
				</c:when>

				<c:otherwise>.
      				<a href="#" class="nav-link"/>
				</c:otherwise>
			</c:choose> <i class="nav-icon fas fa-copy"></i>
			<p>
				Approved Laboratory <i class="fas fa-angle-left right"></i>

			</p> </a>
			<ul class="nav nav-treeview">
				<li class="nav-item"><a
					href="${contextRoot}/measuring/equipment/customer/list-laboratory.htm"
					class="nav-link"> <i class="far fa-circle nav-icon"></i>
						<p>List of Approved Laboratory</p>
				</a></li>
			</ul></li>

	</ul>
</nav>
<!-- /.sidebar-menu -->
</div>
<!-- /.sidebar -->
</aside>
