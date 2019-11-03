<%@include file="../header/header.jsp" %>
  <noscript>
            &amp;amp;amp;amp;amp;amp;lt;div class="alert alert-block col-md-12"&amp;amp;amp;amp;amp;amp;gt;
                &amp;amp;amp;amp;amp;amp;lt;h4 class="alert-heading"&amp;amp;amp;amp;amp;amp;gt;Warning!&amp;amp;amp;amp;amp;amp;lt;/h4&amp;amp;amp;amp;amp;amp;gt;

                &amp;amp;amp;amp;amp;amp;lt;p&amp;amp;amp;amp;amp;amp;gt;You need to have &amp;amp;amp;amp;amp;amp;lt;a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank"&amp;amp;amp;amp;amp;amp;gt;JavaScript&amp;amp;amp;amp;amp;amp;lt;/a&amp;amp;amp;amp;amp;amp;gt;
                    enabled to use this site.&amp;amp;amp;amp;amp;amp;lt;/p&amp;amp;amp;amp;amp;amp;gt;
            &amp;amp;amp;amp;amp;amp;lt;/div&amp;amp;amp;amp;amp;amp;gt;
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
    
</div>





<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i>Professional Details</h2>

                <div class="box-icon">
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/form.html#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/form.html#" class="btn btn-minimize btn-round btn-default"><i class="glyphicon glyphicon-chevron-up"></i></a>
                    
                </div>
            </div>
            <div class="box-content" style="display: block;">
                <form role="form">
                 <c:if test="${empty profiledata}">
                 <tr>
			<td colspan="4">No Results found</td>
	</tr></c:if>
	
	<c:if test="${!empty profiledata}">
	<c:forEach var="allemployee" items="${profiledata}">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Photograph</label>
<p class="help-block">Example block-level help text here.</p>
                        
                    </div>

<div class="form-group">
                        <label for="exampleInputEmail1">Employee Name</label>
<p class="help-block"><c:out value="${allemployee.employee.empName}"></c:out>.</p>
                        
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Employee Id</label>
<p class="help-block"><c:out value="${allemployee.employee.empId}"></c:out></p>
                        
                    </div>
                    <div class="form-group">
                        <label for="exampleInputFile">Designation</label>
                        

                        <p class="help-block"><c:out value="${allemployee.employee.empDesignation}"></c:out></p>
                    </div>
                    
                </form>

            </div>
        </div>
        </c:forEach>
        </c:if>
    </div>
    <!--/span-->

</div>
<div class="row">
 <c:if test="${empty profiledata}">
                 <tr>
			<td colspan="4">No Results found</td>
	</tr></c:if>
	
	<c:if test="${!empty profiledata}">
	<c:forEach var="allemployee1" items="${profiledata}">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i>Personal Details</h2>

                <div class="box-icon">
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/form.html#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/form.html#" class="btn btn-minimize btn-round btn-default"><i class="glyphicon glyphicon-chevron-up"></i></a>
                    
                </div>
            </div>
<br>
<br>
  
                <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">Name</label>
<p class="help-block"><c:out value="${allemployee1.employee.empName}"></c:out></p>
                    
                </div>
                <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputWarning1">Father's Name</label>
<p class="help-block"><c:out value="${allemployee1.empFatherName}"></c:out></p>
                    
                </div>
                
<div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputError1">Mothers Name</label>
<p class="help-block"><c:out value="${allemployee1.empMotherName}"></c:out></p>

                    
                </div><br>


              <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputError1">Personal Email</label>
<p class="help-block"><c:out value="${allemployee1.empContact.email}"></c:out></p>
                    
                </div><br>

              <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputError1">Mobile NO</label>
<p class="help-block"><c:out value="${allemployee1.empContact.mobile}"></c:out></p>
                    
                </div><br>

              <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputError1">Address</label>
<p class="help-block"><c:out value="${allemployee1.employee.empDesignation}"></c:out></p>
                    
                </div><br>

              <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputError1">Gender</label>
<p class="help-block"><c:out value="${allemployee1.empGender}"></c:out></p>
                    
                </div><br>


              <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputError1">Marrital status</label>
<p class="help-block"><c:out value="${allemployee1.employee.empDesignation}"></c:out></p>
                    
                </div><br>

                <form class="form-inline" role="form">
                    <div class="form-group has-success has-feedback">
                        
                    </div>
                </form>
                
            
  <div class="box-content" style="display: block;">
                <div class="control-group">
                   
                    
                </div>
                <div class="control-group">
</div>
                
                
<br><br>

                
    			<br>

                
                
                

                <br>
              
            </div>
        </div>
    </div>
    <!--/span-->

</div><!--/row-->

<div class="row">
<%-- <c:if test="${empty profiledata}">
                 <tr>
			<td colspan="4">No Results found</td>
	</tr></c:if>
	
	<c:if test="${!empty profiledata}">
	<c:forEach var="allemployee2" items="${profiledata}"> --%>
    <div class="box col-md-12">
      <%--   <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i>Bank Details</h2>

                <div class="box-icon">
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/form.html#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/form.html#" class="btn btn-minimize btn-round btn-default"><i class="glyphicon glyphicon-chevron-up"></i></a>
                    
                </div>
            </div>
            <div class="box-content" style="display: block;">
                <form role="form">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Bank Name</label>
<p class="help-block"> <c:out value="${allemployee1.bankdetails.bName}"> </c:out></p>
                        
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Bank Branch</label>
<p class="help-block"><c:out value="${allemployee1.bBranch}"> </c:out></p>
                        
                    </div>
                    <div class="form-group">
                        <label for="exampleInputFile">Account No</label>
                        

                        <p class="help-block"><c:out value="${allemployee1.account}"></c:out></p>
                    </div>
                    
                    
                </form>

            </div>
        </div> --%>
    </div>
    
    </c:forEach>
                </c:if>
                
    <!--/span-->
    

</div><!--/row-->

    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

    <!-- Ad, you can remove it -->
    
    <!-- Ad ends -->

    <hr>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

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
    </div>


<%@ include file="../footer/footer.jsp"%>