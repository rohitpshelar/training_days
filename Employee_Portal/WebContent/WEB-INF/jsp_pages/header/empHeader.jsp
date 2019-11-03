<!DOCTYPE html>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ExtremityIndia Technologies</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="${pageContext.request.contextPath}/resources/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/css/charisma-app.css" rel="stylesheet">
    <link href='${pageContext.request.contextPath}/resources/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='${pageContext.request.contextPath}/resources/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/css/jquery.noty.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/css/noty_theme_default.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/css/elfinder.min.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/css/elfinder.theme.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/css/uploadify.css' rel='stylesheet'>
    <link href='${pageContext.request.contextPath}/resources/css/animate.min.css' rel='stylesheet'>


  <!-- external javascript -->

<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='${pageContext.request.contextPath}/resources/bower_components/moment/min/moment.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="${pageContext.request.contextPath}/resources/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="${pageContext.request.contextPath}/resources/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="${pageContext.request.contextPath}/resources/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="${pageContext.request.contextPath}/resources/js/charisma.js"></script>
    
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
    
  

</head>

<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><%--  <img alt="Charisma Logo" src="${pageContext.request.contextPath}/resources/img/logo20.png" class="hidden-xs"/> --%>
                <span>ExtremityIndia Technologies</span></a>

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs">Employee</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                  
                    <li class="divider"></li>
                    <li> <form name="login.action" action="<c:url value='/j_spring_security_logout' />" method="post" class="form-narrow">
	                
	                
	                
	 <button class="btn btn-lg btn-primary btn-block" type="submit">logout</button>
	 
	 <input type="hidden" value="${j_spring_security_check}">
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					
					</form></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

                          <li>
                  
                </li>
            </ul>

        </div>
    </div>
   <div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        <li class="active"><a class="ajax-link" href="file:///F:/Spring_Project_Workspace/editedSpace/EmployeePortal/src/main/webapp/index.html"><i class="glyphicon glyphicon-home"></i><span> Dashboard</span></a>
                        </li>
                        <li><a class="ajax-link" href="file:///F:/Spring_Project_Workspace/editedSpace/EmployeePortal/src/main/webapp/registration.html"><span> My Profile</span></a>
                        </li>
                        <li><a class="ajax-link" href="file:///F:/Spring_Project_Workspace/editedSpace/EmployeePortal/src/main/webapp/form.html"><span> Leave</span></a></li>
                        <li><a class="ajax-link" href="file:///F:/Spring_Project_Workspace/editedSpace/EmployeePortal/src/main/webapp/chart.html"><span> PaySlip</span></a>
                        </li>
                        <li><a class="ajax-link" href="file:///F:/Spring_Project_Workspace/editedSpace/EmployeePortal/src/main/webapp/typography.html"><span> HRA</span></a>
                        </li>
                        <li><a class="ajax-link" href="file:///F:/Spring_Project_Workspace/editedSpace/EmployeePortal/src/main/webapp/gallery.html"><span> Incentive</span></a>
                        </li>
  
  						<li><a class="ajax-link" href="file:///F:/Spring_Project_Workspace/editedSpace/EmployeePortal/src/main/webapp/gallery.html"><span> Repository</span></a>
                        </li>
  						<li><a class="ajax-link" href="file:///F:/Spring_Project_Workspace/editedSpace/EmployeePortal/src/main/webapp/gallery.html"><span> IT Declaration</span></a>
                        </li>
 						 <li><a class="ajax-link" href="file:///F:/Spring_Project_Workspace/editedSpace/EmployeePortal/src/main/webapp/gallery.html"><span> Attendance</span></a>
                        </li>
<li><a class="ajax-link" href="file:///F:/Spring_Project_Workspace/editedSpace/EmployeePortal/src/main/webapp/gallery.html"><span> Reports</span></a>
                        </li>
  
  
  
                      </ul></div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->
