<%@include file="../header/hrHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

       

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
                <div>
        <ul class="breadcrumb">
            <li>
                <a href="#">Home</a>
            </li>
            <li>
                <a href="#">Tables</a>
            </li>
        </ul>
    </div>
    
    <script type="text/javascript">
  function edit(id) {
	 
	  alert("inside edit:"+id);
	
}
    </script>
     <script type="text/javascript">
    function delete1(id){
    	
    alert("inside delete1:"+id)
		
	}
    </script>
     <script type="text/javascript">
     function view(id) {
    	 alert("inside view:"+id)
		
	}
    </script>

    <div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class="glyphicon glyphicon-user"></i> All Employee's Data</h2>

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
        <th>Username</th>
        <th>Date registered</th>
        <th>Role</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${empList}" var="person">
    <tr>
    <td class="centre">${person.empId}</td>
    <td class="center">${person.empName}</td>
    <td class="centre">${person.empJoiningDate}</td>
    <td class="center"></td>
     <td class="center">
            <a class="btn btn-success"  onclick="view(id);" id="${person.empId}">
                <i class="glyphicon glyphicon-zoom-in icon-white"></i>
                View
            </a>
            <a class="btn btn-info" onclick="edit(${person.empId});" id="${person.empId}">
                <i class="glyphicon glyphicon-edit icon-white"></i>
                Edit
            </a>
            <a class="btn btn-danger" onclick="delete1(${person.empId});" id="${person.empId}" >
                <i class="glyphicon glyphicon-trash icon-white"></i>
                Delete
            </a>
        </td>
    </tr>
    </c:forEach>
  
    </tbody>
    </table>
    </div>
    </div>
    </div>
    <!--/span-->

   

    

   

<%@ include file="../footer/footer.jsp"%>
