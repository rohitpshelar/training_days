<%@include file="../header/header.jsp"%>
<!-- alert(<div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    <strong>Well done!</strong> You successfully read this important alert message.
                </div>); -->

<noscript>&amp;amp;amp;amp;amp;amp;amp;amp;lt;div
	class="alert alert-block col-md-12"&amp;amp;amp;amp;amp;amp;amp;amp;gt;
	&amp;amp;amp;amp;amp;amp;amp;amp;lt;h4
	class="alert-heading"&amp;amp;amp;amp;amp;amp;amp;amp;gt;Warning!&amp;amp;amp;amp;amp;amp;amp;amp;lt;/h4&amp;amp;amp;amp;amp;amp;amp;amp;gt;

	&amp;amp;amp;amp;amp;amp;amp;amp;lt;p&amp;amp;amp;amp;amp;amp;amp;amp;gt;You
	need to have &amp;amp;amp;amp;amp;amp;amp;amp;lt;a
	href="http://en.wikipedia.org/wiki/JavaScript"
	target="_blank"&amp;amp;amp;amp;amp;amp;amp;amp;gt;JavaScript&amp;amp;amp;amp;amp;amp;amp;amp;lt;/a&amp;amp;amp;amp;amp;amp;amp;amp;gt;
	enabled to use this
	site.&amp;amp;amp;amp;amp;amp;amp;amp;lt;/p&amp;amp;amp;amp;amp;amp;amp;amp;gt;
	&amp;amp;amp;amp;amp;amp;amp;amp;lt;/div&amp;amp;amp;amp;amp;amp;amp;amp;gt;
</noscript>

<div id="content" class="col-lg-10 col-sm-10">
	<!-- content starts -->
	<div>

		
	</div>

	<form action="${pageContext.request.contextPath}/admin/updatehr">

		<div class="box-inner">
			<div class="box-header well" data-original-title="">
				<h2>
					<i class="glyphicon glyphicon-edit"></i> HR Details
				</h2>

				<div class="box-icon">
					<a
						href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/profile.html#"
						class="btn btn-setting btn-round btn-default"><i
						class="glyphicon glyphicon-cog"></i></a> <a
						href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/profile.html#"
						class="btn btn-minimize btn-round btn-default"><i
						class="glyphicon glyphicon-chevron-up"></i></a> <a
						href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/profile.html#"
						class="btn btn-close btn-round btn-default"><i
						class="glyphicon glyphicon-remove"></i></a>
				</div>
			</div>

			<c:if test="${empty editEmployeedata}">
				<p>colspan="4">No Results found</p>
			</c:if>

			<c:if test="${!empty editEmployeedata}">
				<c:forEach var="editemp" items="${editEmployeedata}">
					<div class="box-content">

						<div class="form-group has-success col-md-4">
							<label class="control-label" for="inputSuccess1">ID</label> <input
								type="text" value="${editemp.id}" name="id" class="form-control"
								id="inputSuccess1">
						</div>

						<div class="form-group has-success col-md-4">
							<label class="control-label" for="inputSuccess1">Username</label>
							<input type="text" value="${editemp.username}" name="username"
								class="form-control" id="inputSuccess1">
						</div>
						<div class="form-group has-success col-md-4">
							<label class="control-label" for="inputSuccess1">Branch</label> <input
								type="text" value="${editemp.branch}" name="branch"
								class="form-control" id="inputSuccess1">
						</div>
						<div class="form-group has-success col-md-4">
							<label class="control-label" for="inputSuccess1">Email</label> <input
								type="text" value="${editemp.email}" name="email"
								class="form-control" id="inputSuccess1">
						</div>
						<div class="form-group has-success col-md-4">
							<label class="control-label" for="inputSuccess1"></label> <input
								type="hidden" value="${editemp.status}" name="status"
								class="form-control" id="inputSuccess1">
						</div>
						
				</c:forEach>
			</c:if>




<br>
<br>


			<input type="submit" class="btn btn-primary">





		</div>
	</form>



</div>

</div>
<!--/#content.col-md-0-->
</div>
<!--/fluid-row-->



<hr>

<!--  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

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
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/form.html#" class="btn btn-default" data-dismiss="modal">Close</a>
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/form.html#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                </div>
            </div>
        </div>
    </div> -->


<%@ include file="../footer/footer.jsp"%>