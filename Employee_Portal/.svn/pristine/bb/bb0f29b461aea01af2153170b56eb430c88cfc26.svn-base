<%@page import="com.extremity.emp.model.Employee"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@include file="../header/hrHeader.jsp"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%-- function getTeam(id) {
	alert("inside Second:"+id.value);
	var request;
	 if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} 
var URL = "${pageContext.request.contextPath}hr/showTeams?teamId="+id.value;
request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			//alert('dasda');
			document.getElementById('showTeams').innerHTML = request.responseText;
		}
	
	request.open("GET", URL, true);
	request.send();
} 

} --%>
<script type="text/javascript">
function  getTeam(id) {  
	  alert("inside:"+id.value);
	  var id=$('#teamList').val();
	$.ajax({  
		
		 data : {
		        'id' :id 
		        },
		 url: "${pageContext.request.contextPath}/hr/showTeams",
	    type: "GET", 
	 
	    success: function (response) 
        {
	    	 alert(response)
            $('#team').append(response);
        },
	  });  
	}  
</script>
<script type="text/javascript">
<!--

//-->

function teamSelect(eid,empid)
{
	
	alert("team id:"+eid.value+"=== emp id: "+empid)
	$.ajax({  
		 
		
		 data : {
		        'tid' :eid.value ,
		        'empId' :empid
		        },
		        url: "${pageContext.request.contextPath}/hr/insertTeam",
	   			
		        type: "GET", 
		        success: function (response) 
		        {
		        	if(response!=null)
		        		{
		        	$("#team > option[value$='response']").hide();
		        		}
		        },
	    error: function(e){  
	      alert('Error: ');  
	    }  
	  });  
}  
</script>
<body>

	<div id="content" class="col-lg-10 col-sm-10">
		<!-- content starts -->
		<div>
			<ul class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li><a href="#">Tables</a></li>
			</ul>
		</div>

		<div class="row">
			<div class="box col-md-12">
				<div class="box-inner">
					<div class="box-header well">

						<h2>Available Teams :---  </h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round btn-default"><i
								class="glyphicon glyphicon-cog"></i></a> <a href="#"
								class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
								class="btn btn-close btn-round btn-default"><i
								class="glyphicon glyphicon-remove"></i></a>
						</div>
					<div class="controls">
						<div class="box-header well">
							 <select name="selectTeam" data-rel="chosen"
								onchange="getTeam(this);" id="teamList">
								<option value="">select</option>
								<option value="1">core java</option>
								<option value="2">jsp servlet</option>
								<option value="3">struts</option>
								<option value="4">spring hibernate</option>


							</select>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- Ajax response will get print here -->
<div id="team"></div>
	
<div class="box col-md-12">
				<div class="box-inner">
					<div class="box-header well">

						<h2>Allocate the team for Employee</h2>

</div>
		</div>
		</div>
		<div class="box-content">
		
		<form:form method="POST">
				<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive">
					<thead>
						<tr>
							<!-- <th>Select Here</th> -->
							<th>Emp Id</th>
							<th>Emp Name</th>
							<th>Select Team</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${empList}" var="person">
						<tr>
							<td class="centre">${person.empId}</td>
								<td class="center">${person.empName}</td>

								<td>
									<div class="controls">

										Choose Team <select name="team" data-rel="chosen"
											onchange="teamSelect(this,${person.empId});"
											id="${person.empId}">
											<option value="">select</option>
											<option value="1">core java</option>
											<option value="2">jsp servlet</option>
											<option value="3">struts</option>
											<option value="4">spring hibernate</option>


										</select>


									</div>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

			</form:form>
		</div>
		</div>
		
	</div>
</body>
<!--/span-->
<%@ include file="../footer/footer.jsp"%>






