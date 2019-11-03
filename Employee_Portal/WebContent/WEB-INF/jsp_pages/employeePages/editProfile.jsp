<%@include file="../header/header.jsp" %>

<!-- alert(<div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert">×</button>
                    <strong>Well done!</strong> You successfully read this important alert message.
                </div>); -->
 
        <noscript>
            &amp;amp;amp;amp;amp;amp;amp;amp;lt;div class="alert alert-block col-md-12"&amp;amp;amp;amp;amp;amp;amp;amp;gt;
                &amp;amp;amp;amp;amp;amp;amp;amp;lt;h4 class="alert-heading"&amp;amp;amp;amp;amp;amp;amp;amp;gt;Warning!&amp;amp;amp;amp;amp;amp;amp;amp;lt;/h4&amp;amp;amp;amp;amp;amp;amp;amp;gt;

                &amp;amp;amp;amp;amp;amp;amp;amp;lt;p&amp;amp;amp;amp;amp;amp;amp;amp;gt;You need to have &amp;amp;amp;amp;amp;amp;amp;amp;lt;a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank"&amp;amp;amp;amp;amp;amp;amp;amp;gt;JavaScript&amp;amp;amp;amp;amp;amp;amp;amp;lt;/a&amp;amp;amp;amp;amp;amp;amp;amp;gt;
                    enabled to use this site.&amp;amp;amp;amp;amp;amp;amp;amp;lt;/p&amp;amp;amp;amp;amp;amp;amp;amp;gt;
            &amp;amp;amp;amp;amp;amp;amp;amp;lt;/div&amp;amp;amp;amp;amp;amp;amp;amp;gt;
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
    
</div>

 <form action="${pageContext.request.contextPath}/admin/updateEmployee" > 

<div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i> Employee Personal  Details</h2>

                <div class="box-icon">
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/profile.html#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/profile.html#" class="btn btn-minimize btn-round btn-default"><i class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="file:///C:/Users/Admin/Desktop/EmployeePortal/src/main/webapp/profile.html#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
          
             <c:if test="${empty editEmployeedata}">
			<p>colspan="4">No Results found</p>
	</c:if>
	
	<c:if test="${!empty editEmployeedata}">
	<c:forEach var="editemp" items="${editEmployeedata}">
            <div class="box-content">
                
  <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">UserId</label>
                    <input type="text" value="${editemp.empId}" name="empId" class="form-control" id="inputSuccess1">
                </div>              
 <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">Name</label>
                    <input type="text" value="${editemp.empName}" name="empName" class="form-control" id="inputSuccess1">
                </div>
  <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">Designation</label>
                    <input type="text" value="${editemp.empDesignation}" name="empDesignation" class="form-control" id="inputSuccess1">
                </div>
  <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1">Team Name</label>
                    <input type="text" value="${editemp.empTeam}" name="empTeam" class="form-control" id="inputSuccess1">
                </div>
  <div class="form-group has-success col-md-4">
                    <label class="control-label" for="inputSuccess1"></label>
                    <input type="hidden" value="${editemp.empJoiningDate}" name="empJoiningDate" class="form-control" id="inputSuccess1">
                </div>
  



   </c:forEach>
                </c:if>
                
                
                <br>


                
                
<br>
                
    <br>            
                
<label class="control-label" for="selectError1"></label>
<br>
       
               <!--  <label class="radio-inline">
                    <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">Male</label>
                <label class="radio-inline">
                    <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">Female    </label>            </label>
                
 -->
                <br>
                <br>

                <br>

                
                
                
             <input type="submit"  class="btn btn-primary" >
                
                
                
              
              
                         </div>
                         </form>
                        
        </div>


   
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

   




<%@ include file="../footer/footer.jsp"%>