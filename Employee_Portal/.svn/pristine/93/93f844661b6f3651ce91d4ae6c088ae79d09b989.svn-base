<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.extremity.emp.model.EmpLeave"%>
<%@page import="java.util.List"%>
<%@include file="../header/hrHeader.jsp" %>

	
			<div id="content" class="col-lg-10 col-sm-10">
				<!-- content starts -->
				<div>
					
				</div>
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-user"></i>Todays leave Requests
									
								</h2>

								<!-- <div class="box-icon">
									<a href="#" class="btn btn-setting btn-round btn-default"><i
										class="glyphicon glyphicon-cog"></i></a> <a href="#"
										class="btn btn-minimize btn-round btn-default"><i
										class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
										class="btn btn-close btn-round btn-default"><i
										class="glyphicon glyphicon-remove"></i></a>
								</div> -->
							</div>
							<div class="box-content">
								
								<table
									class="table table-striped table-bordered bootstrap-datatable datatable responsive">
									<thead>
										<tr>
											<th>Username</th>
										<!-- 	<th>Date registered</th> -->
											<th>Report Manager</th>
											<th>Leave_Type</th>
											<th>Reason</th>
											<th>From</th>
											<th>To</th>
											<th>No of Days</th>
											<th>Actions</th>
										</tr>
										
									<% ArrayList<EmpLeave> l = (ArrayList<EmpLeave>)request.getAttribute("leave");
										
										for(EmpLeave e : l)
										{
										
										%> 
										<tr>
										<!-- 	<th>Date registered</th> -->
											<td><%=e.getEmployee().getEmpName()%></td>
											<td><%=e.getReportManagerName()%></td>
											<td><%=e.getLType()%></td>
											<td><%=e.getReasons()%></td>
											<td><%=e.getFrom()%></td>
											<td><%=e.getTo()%></td>
											<td><%=e.getNoDay()%></td> 
										
											<td class="center"><a class="btn btn-success"  onclick="approve(id);" id="<%= e.getEmpContact().getEmail()%>" <%-- href="${pageContext.request.contextPath}/hr/approveLeave" --%>>
													<i class="glyphicon glyphicon-zoom-in icon-white"></i>
													Approve
											
											</a> <a class="btn btn-danger" onclick="reject(id);" id="<%= e.getEmpContact().getEmail()%>" <%-- href="${pageContext.request.contextPath}/hr/rejectLeave" --%>> <i class="glyphicon glyphicon-trash icon-white"></i> Reject
											</a></td>
										</tr>
										 <%} %> 
										
									</thead>
									<tbody>
										<!-- write contents here for leave requests  -->

									</tbody>
								</table>
								<ul class="pagination pagination-centered">
									<li><a href="#">Prev</a></li>
									<li class="active"><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">Next</a></li>
								</ul>
								
								<%-- <a class="btn btn-success"  onclick="approve(id);" id="" href="${pageContext.request.contextPath}/hr/approveLeave">
													<i class="glyphicon glyphicon-zoom-in icon-white"></i>Approve all
											
								</a> <a class="btn btn-danger" onclick="reject(id);" id="" href="${pageContext.request.contextPath}/hr/rejectLeave"> 
													<i class="glyphicon glyphicon-trash icon-white"></i> Reject all
								</a> --%>
							</div>
						</div>
					</div>
					<!--/span-->

					<!-- content ends -->
				</div>
				<!--/#content.col-md-0-->

								<!--/#content.col-md-0-->
			</div>
			<!--/fluid-row-->

			<!-- Ad, you can remove it -->
			<div class="row">
				<div class="col-md-9 col-lg-9 col-xs-9  hidden-xs">
					<script async
						src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
					<!-- Charisma Demo 2 -->
					<ins class="adsbygoogle"
						style="display: inline-block; width: 728px; height: 90px"
						data-ad-client="ca-pub-5108790028230107" data-ad-slot="3193373905"></ins>
					<script>
						(adsbygoogle = window.adsbygoogle || []).push({});
					</script>
				</div>
			
			</div>
			<!-- Ad ends -->

			<hr>

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">

				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h3>Settings</h3>
						</div>
						<div class="modal-body">
							<p>Here settings can be configured...</p>
						</div>
						<div class="modal-footer">
							<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
							<a href="#" class="btn btn-primary" data-dismiss="modal">Save
								changes</a>
						</div>
					</div>
				</div>
			</div>


<script type="text/javascript">

function approve(id)
{
	 alert("inside:"+id);
	  //var id=$('#empid').val();
	$.ajax({  
		
		 data : {
		        'id' :id 
		        },
		 url: "${pageContext.request.contextPath}/hr/approveLeave?id="+id+"",
	    type: "GET", 
	   
	    success: function(response){  
	      // we have the response  
	      $('#info').html(response);
	     
	    },  
	    error: function(e){  
	      alert('Error: ');  
	    }  
	  });  

}

function reject(id)
{
	
	 alert("inside:"+id);
	 // var id=$('#empid1').val();
	$.ajax({  
		
		 data : {
		        'id' :id 
		        },
		 url: "${pageContext.request.contextPath}/hr/rejectLeave?id="+id+"",
	    type: "GET", 
	   
	    
	    success: function(response){  
	      // we have the response  
	      $('#info').html(response);
	     
	    },  
	    error: function(e){  
	      alert('Error: ');  
	    }  
	  });  

}

</script>


<div style="clear: both"></div>
<%@ include file="../footer/footer.jsp"%>