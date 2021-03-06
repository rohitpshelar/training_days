
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- Mirrored from seantheme.com/color-admin-v1.7/admin/html/calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 24 Apr 2015 10:59:24 GMT -->
<head>


<!-- ================== BEGIN BASE CSS STYLE ================== -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet">
<link
	href="assets/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css"
	rel="stylesheet" />
<link href="assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="assets/css/animate.min.css" rel="stylesheet" />
<link href="assets/css/style.min.css" rel="stylesheet" />
<link href="assets/css/style-responsive.min.css" rel="stylesheet" />
<link href="assets/css/theme/default.css" rel="stylesheet" id="theme" />
<!-- ================== END BASE CSS STYLE ================== -->

<!-- ================== BEGIN PAGE LEVEL STYLE ================== -->
<link href="assets/plugins/fullcalendar/fullcalendar/fullcalendar.css"
	rel="stylesheet" />
<!-- ================== END PAGE LEVEL STYLE ================== -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="assets/plugins/pace/pace.min.js"></script>
<!-- ================== END BASE JS ================== -->
</head>
<body>





	<!-- begin panel -->
	<div class="panel panel-inverse">
		<div class="panel-heading">
			<div class="panel-heading-btn">
				<a href="javascript:;"
					class="btn btn-xs btn-icon btn-circle btn-default"
					data-click="panel-expand"><i class="fa fa-expand"></i></a> <a
					href="javascript:;"
					class="btn btn-xs btn-icon btn-circle btn-success"
					data-click="panel-reload"><i class="fa fa-repeat"></i></a> <a
					href="javascript:;"
					class="btn btn-xs btn-icon btn-circle btn-warning"
					data-click="panel-collapse"><i class="fa fa-minus"></i></a> <a
					href="javascript:;"
					class="btn btn-xs btn-icon btn-circle btn-danger"
					data-click="panel-remove"><i class="fa fa-times"></i></a>
			</div>
			<h4 class="panel-title">Calendar</h4>
		</div>
		<div class="panel-body p-0">
			<div class="vertical-box">
				<div class="vertical-box-column p-15 bg-silver width-sm">
					<div id="external-events" class="calendar-event">
						<h4 class=" m-b-20">Draggable Events</h4>
						<div class="external-event bg-purple" data-bg="bg-purple"
							data-title="Discussion"
							data-media="<i class='fa fa-comments'></i>"
							data-desc="Lorem ipsum dolor sit amet, consectetur adipiscing elit.">
							<h5>
								<i class="fa fa-comments fa-lg fa-fw"></i> Discussion
							</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
						</div>
						<div class="external-event bg-blue" data-bg="bg-blue"
							data-title="Dinner" data-media="<i class='fa fa-cutlery'></i>"
							data-desc="Cum sociis natoque penatibus et magnis dis parturient montes.">
							<h5>
								<i class="fa fa-cutlery fa-lg fa-fw"></i> Dinner
							</h5>
							<p>Cum sociis natoque penatibus et magnis dis parturient
								montes.</p>
						</div>
						<div class="external-event bg-green" data-bg="bg-green"
							data-title="Brainstorming"
							data-media="<i class='fa fa-lightbulb-o'></i>"
							data-desc="Mauris tristique massa eu venenatis semper. Phasellus a nibh nisi.">
							<h5>
								<i class="fa fa-lightbulb-o fa-lg fa-fw"></i> Brainstorming
							</h5>
							<p>Mauris tristique massa eu venenatis semper. Phasellus a
								nibh nisi.</p>
						</div>
						<div class="external-event bg-orange" data-bg="bg-orange"
							data-title="Performance Rating"
							data-media="<i class='fa fa-tasks'></i>"
							data-desc="Class aptent taciti sociosqu ad litora torquent per conubia nostra.">
							<h5>
								<i class="fa fa-tasks fa-lg fa-fw"></i> Performance Rating
							</h5>
							<p>Class aptent taciti sociosqu ad litora torquent per
								conubia nostra.</p>
						</div>
						<div class="external-event bg-red" data-bg="bg-red"
							data-title="Video Shooting"
							data-media="<i class='fa fa-video-camera'></i>"
							data-desc="Donec ligula nisi, tempus eu egestas id, auctor sit amet velit.">
							<h5>
								<i class="fa fa-video-camera fa-lg fa-fw"></i> Video Shooting
							</h5>
							<p>Donec ligula nisi, tempus eu egestas id, auctor sit amet
								velit.</p>
						</div>
						<div class="checkbox">
							<label> <input type="checkbox" id="drop-remove" />
								remove after drop
							</label>
						</div>
					</div>
				</div>
				<div id="calendar"></div>
			</div>
		</div>
	</div>
	<!-- end panel -->
	</div>
	<!-- end #content -->




	<!-- ================== BEGIN BASE JS ================== -->
	<script src="assets/plugins/jquery/jquery-1.9.1.min.js"></script>
	<script src="assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
	<script src="assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!--[if lt IE 9]>
		<script src="assets/crossbrowserjs/html5shiv.js"></script>
		<script src="assets/crossbrowserjs/respond.min.js"></script>
		<script src="assets/crossbrowserjs/excanvas.min.js"></script>
	<![endif]-->
	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/plugins/jquery-cookie/jquery.cookie.js"></script>
	<!-- ================== END BASE JS ================== -->

	<!-- ================== BEGIN PAGE LEVEL JS ================== -->
	<script src="assets/plugins/fullcalendar/fullcalendar/fullcalendar.js"></script>
	<script src="assets/js/calendar.demo.min.js"></script>
	<script src="assets/js/apps.min.js"></script>
	<!-- ================== END PAGE LEVEL JS ================== -->

	<script>
		$(document).ready(function() {
			App.init();
			Calendar.init();
		});
	</script>

</body>

<!-- Mirrored from seantheme.com/color-admin-v1.7/admin/html/calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 24 Apr 2015 10:59:26 GMT -->
</html>
