<%@include file="../header/hrHeader.jsp" %>
     <script>
function deleteemployee(id) {
	//alert(id);
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		window.location.href="${pageContext.request.contextPath}/hr/deleteemployee?id="+id;
	}
}
</script>
     <script>
function UserContact(id) {
	//alert(id);
	var isOK = confirm("Are you sure ?");
	if(isOK)
	{
		window.location.href="${pageContext.request.contextPath}/hr/newempprofile?id="+id;
	}
}

function editContact(id) {
	//alert(id);
	var isOK = confirm("Are you sure u want to edit?");
	if(isOK)
	{
		window.location.href="${pageContext.request.contextPath}/hr/editEmployee?id="+id;
	}
}
</script>

       <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
                <div>
       
    </div>

    <div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class="glyphicon glyphicon-user"></i> Employees Details</h2>

        <div class="box-icon">
            <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
            <a href="#" class="btn btn-minimize btn-round btn-default"><i
                    class="glyphicon glyphicon-chevron-up"></i></a>
            <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
        </div>
    </div>
    <div class="box-content">
   
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
    <thead>
    <tr>
        <th>UserId</th>
        <th>Designation</th>
        <th>DOB</th>
        <th>Username</th>
        <th>Team</th>
          <th>Details</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty EMPLOYEE_GET_ALL_DATA}">
    <tr>
			<td colspan="4">No Results found</td>
	</tr></c:if>
	
	<c:if test="${!empty EMPLOYEE_GET_ALL_DATA}">
	<c:forEach var="allemployee" items="${EMPLOYEE_GET_ALL_DATA}">
    <tr>
         <tr>
				<td class="center" ><c:out value="${allemployee.empId}"></c:out></td>
				<td class="center"><c:out value="${allemployee.empDesignation}"></c:out></td>
				<td class="center"><c:out value="${allemployee.empJoiningDate}"></c:out> </td>
				<td class="center"><c:out value="${allemployee.empName}"></c:out></td>
				<td class="center"><c:out value="${allemployee.empTeam}"></c:out></td>
				
          <td class="center">			
   
			<div class="btn-group">
                    <a class="btn btn-primary" href="#"><i class="glyphicon glyphicon-user icon-white"></i> User</a>
                    <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="javascript:editContact(${allemployee.empId})"><i class="glyphicon glyphicon-pencil" ></i> Edit</a></li>
                        <li><a href="javascript:deleteemployee(${allemployee.empId})"><i class="glyphicon glyphicon-trash"></i> Delete</a></li>
                        <li><a href="javascript:UserContact(${allemployee.empId})"><i class="glyphicon glyphicon-pencil" ></i> Profile</a></li>
						 <li><a href="${pageContext.request.contextPath}/hr/attendence?id=${allemployee.empId}"><i class="glyphicon glyphicon-ban-circle"></i> View Attendance</a></li>
                        <li class="divider"></li>
                    </ul>

                </div>
        </td>
    </tr>
    </c:forEach>
    </c:if>
  
  <%-- //href="${pageContext.request.contextPath}/admin/editEmployee?id=${allemployee.emp_id}" --%>
    
   
    </tbody>
    </table>
    </div>
    </div>
    </div>
    <!--/span-->

    </div><!--/row-->


   

    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

   
   

<div style="clear:both"></div>
    <%@include file="../footer/footer.jsp"%>