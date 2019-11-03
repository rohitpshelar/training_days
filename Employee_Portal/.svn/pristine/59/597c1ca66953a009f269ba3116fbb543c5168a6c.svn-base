<!DOCTYPE html>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/contacts.js"></script>

<meta charset="utf-8">
<title>ExtremityIndia Technologies</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">

<!-- The styles -->
<link id="bs-css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-cerulean.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/charisma-app.css"
	rel="stylesheet">
<link
	href='${pageContext.request.contextPath}/resources/bower_components/fullcalendar/dist/fullcalendar.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/bower_components/fullcalendar/dist/fullcalendar.print.css'
	rel='stylesheet' media='print'>
<link
	href='${pageContext.request.contextPath}/resources/bower_components/chosen/chosen.min.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/bower_components/colorbox/example3/colorbox.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/bower_components/responsive-tables/responsive-tables.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/css/jquery.noty.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/css/noty_theme_default.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/css/elfinder.min.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/css/elfinder.theme.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/css/jquery.iphone.toggle.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/css/uploadify.css'
	rel='stylesheet'>
<link
	href='${pageContext.request.contextPath}/resources/css/animate.min.css'
	rel='stylesheet'>


<!-- jQuery -->
<script
	src="${pageContext.request.contextPath}/resources/bower_components/jquery/jquery.min.js"></script>

<!-- The fav icon -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">

<style>
#panel {
	display: none;
}
</style>




</head>

<body>
	<!-- topbar starts -->
	<!-- topbar starts -->
	<div class="navbar navbar-default" role="navigation">

		<div class="navbar-inner">
			<button type="button" class="navbar-toggle pull-left animated flip">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/jsp/adminPages/adminFront.jsp">
				<img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs" /> <span>ExtremityIndia</span>
			</a> <input type="hidden" value="${j_spring_security_check}"> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<!-- user dropdown starts -->
			<div class="btn-group pull-right">
				<button class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i><span
						class="hidden-sm hidden-xs"> Human Resource</span> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
				
					<li class="divider"></li>
					<li>
						<form name="login.action"
							action="<c:url value='/j_spring_security_logout' />"
							method="post" class="form-narrow">



							<button class="btn btn-lg btn-primary btn-block" type="submit">logout</button>

							<input type="hidden" value="${j_spring_security_check}">

							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

						</form>
					</li>

				</ul>
			</div>

		</div>
	</div>


	</form>
	<!-- topbar ends -->
	<div class="ch-container">
		<div class="row">

			<!-- left menu starts -->
			<div class="col-sm-2 col-lg-2">
				<div class="sidebar-nav">
					<div class="nav-canvas">
						<div class="nav-sm nav nav-stacked"></div>
						<ul class="nav nav-pills nav-stacked main-menu">
							<li class="nav-header">Main</li>
							<li><a class="ajax-link"
								href="#"><i
									class="glyphicon glyphicon-home"></i><span> Dashboard</span></a></li>
							<li><a class="ajax-link"
								href="#"><i
									class="glyphicon glyphicon-calendar"></i><span>
										Employee Registration </span></a></li>
							
							<li class="accordion" id="flip"><a href="${pageContext.request.contextPath}/hr/employeedetails""><i
									class="glyphicon glyphicon-plus"></i><span> Employee
										Details</span></a>
										 <li><a class="ajax-link" href="${pageContext.request.contextPath}/hr/teams"><i class="glyphicon glyphicon-font"></i><span> Manage teams</span></a>
                        </li> 
								<ul id="panel" class="nav nav-pills nav-stacked">
									
									
								</ul></li>
							<li><a class="ajax-link"
								href="#"><i
									class="glyphicon glyphicon-calendar"></i><span> Calendar</span></a>
							</li>
							<li><a class="ajax-link" href="#"><i
									class="glyphicon glyphicon-calendar"></i><span> Send
										Message's</span></a></li>
							<li><a class="ajax-link" href="#"><i
									class="glyphicon glyphicon-calendar"></i><span> Send
										Email's</span></a></li>





						</ul>

					</div>
				</div>
			</div>
			<!--/span-->