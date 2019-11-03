<%@include file="../header/header.jsp"%>

<script>
function deleteUserContact(id) {
	//alert(id);
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		window.location.href="${pageContext.request.contextPath}/admin/deleteContact?id="+id;
	}
}
</script>


<script type="text/javascript">
 
 function go(url)
 {
 	window.location = url;
 }
 
 function edithr(url)
 {
	 
	 var isOK = confirm("Are you sure to update?");
	 alert(url)
		if(isOK)
		{
			go(url);
		} 
 }
 
 
 </script>   

<noscript>
	<div class="alert alert-block col-md-12">
		<h4 class="alert-heading">Warning!</h4>

		<p>
			You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
				target="_blank">JavaScript</a> enabled to use this site.
		</p>
	</div>
</noscript>

<div id="content" class="col-lg-10 col-sm-10">
	
	<div>
	
	</div>

	<div class="row">
		<div class="box col-md-12">
			<div class="box-inner">
				<div class="box-header well" data-original-title="">
					<h2>
						<i class="glyphicon glyphicon-user"></i> Human Resource's Details
					</h2>

					<div class="box-icon">
						<a href="#" class="btn btn-setting btn-round btn-default"><i
							class="glyphicon glyphicon-cog"></i></a> <a href="#"
							class="btn btn-minimize btn-round btn-default"><i
							class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
							class="btn btn-close btn-round btn-default"><i
							class="glyphicon glyphicon-remove"></i></a>
					</div>
				</div>
				<div class="box-content">

					<table
						class="table table-striped table-bordered bootstrap-datatable datatable responsive">
						<thead>
							<tr>
								<th>User_ID</th>
								<th>Username</th>
								<th>Branch</th>
								<th>Email_id</th>
								<th>Status</th>
								<th>Details</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty EMPLOYEE_GET_ALL_DATA}">
								<tr>
									<td colspan="4">No Results found</td>
								</tr>
							</c:if>

							<c:if test="${!empty EMPLOYEE_GET_ALL_DATA}">
								<c:forEach var="userrole" items="${EMPLOYEE_GET_ALL_DATA}">
									<tr>
									<tr>
										<td class="center"><c:out value="${userrole.id}"></c:out></td>
										<td class="center"><c:out value="${userrole.username}"></c:out></td>
										<td class="center"><c:out value="${userrole.branch}"></c:out></td>
										<td class="center"><c:out value="${userrole.email}"></c:out>
										<td class="center"><c:out value="${userrole.status}"></c:out>
										</td>
										
										

										<td class="center">

											<div class="btn-group">
												<a class="btn btn-primary" href="#"><i
													class="glyphicon glyphicon-user icon-white"></i> User</a> <a
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" href="#"><span class="caret"></span></a>
												<ul class="dropdown-menu">
												 <li><a onclick="javascript:edithr('${pageContext.request.contextPath}/admin/edithr?id=${userrole.id}');" ><i class="glyphicon glyphicon-pencil" ></i> Edit</a></li>
													<%-- <li><a href="updateContact.do?id=${userrole.id}"><i
															class="glyphicon glyphicon-pencil" data-toggle="modal" data-target="#myM"></i> Edit</a></li> --%>
															
													<li><a href="javascript:deleteUserContact(${userrole.id})"><i class="glyphicon glyphicon-trash"></i> Delete</a></li>
													
													<li><a href="#"><i
															class="glyphicon glyphicon-ban-circle"></i> View Profile</a></li>
													<li><a <%-- href="updateContact.do?id=${userrole.id}" --%>><i
															class="glyphicon glyphicon-ban-circle"></i> View
															Attendance</a></li>
													<li class="divider"></li>

												</ul>

											</div>
										</td>
									</tr>
								</c:forEach>
							</c:if>




						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!--/span-->

	</div>
	<!--/row-->




	<!-- content ends -->
</div>
<!--/#content.col-md-0-->
</div>
<!--/fluid-row-->

<!-- -pop-up starts -->


<div style="clear: both"></div>
<%@include file="../footer/footer.jsp"%>