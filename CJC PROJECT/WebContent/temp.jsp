<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<%@page import="com.cjc.model.RegForm"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<html class="no-js">
<!--<![endif]-->
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
<link href="assets/css/style.min.css" rel="stylesheet" />
<link href="assets/css/style-responsive.min.css" rel="stylesheet" />
<link href="assets/css/theme/default.css" rel="stylesheet" id="theme" />
<!-- ================== END BASE CSS STYLE ================== -->

<!-- ================== BEGIN PAGE CSS STYLE ================== -->
<link
	href="assets/plugins/bootstrap3-editable/css/bootstrap-editable.css"
	rel="stylesheet" />
<link
	href="assets/plugins/bootstrap3-editable/inputs-ext/address/address.css"
	rel="stylesheet" />
<link
	href="assets/plugins/bootstrap3-editable/inputs-ext/typeaheadjs/lib/typeahead.css"
	rel="stylesheet" />
<link href="assets/plugins/bootstrap-datepicker/css/datepicker.css"
	rel="stylesheet" />
<link href="assets/plugins/bootstrap-datepicker/css/datepicker3.css"
	rel="stylesheet" />
<link
	href="assets/plugins/bootstrap-datetimepicker/css/datetimepicker.css"
	rel="stylesheet" />
<link href="assets/plugins/select2/select2.html" rel="stylesheet" />
<link
	href="assets/plugins/bootstrap-wysihtml5/src/bootstrap-wysihtml5.css"
	rel="stylesheet" />
<!-- ================== END PAGE CSS STYLE ================== -->

<!-- ================== BEGIN BASE JS ================== -->
<script src="assets/plugins/pace/pace.min.js"></script>
<!-- ================== END BASE JS ================== -->





<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>C J C</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/font-awesome.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/templatemo-style.css">
<script src="js/vendor/modernizr-2.6.2.min.js"></script>

<script type="text/javascript">
	function rs() {
		var id = document.getElementsByName("r");
		var aa = id;
		document.location.href = "rs?rs=" + aa;

	}
</script>

</head>
<body>
	<div class="responsive-header visible-xs visible-sm">
		<%
			ArrayList al = (ArrayList) request.getAttribute("data");

			Iterator itr = al.iterator();
			while (itr.hasNext()) {
				RegForm rf = (RegForm) itr.next();
		%>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="top-section">
						<div class="profile-image">

							<img src="<%=rf.getPhoto()%>" alt="Volton">

						</div>
						<div class="profile-content">
							<h3 style="text-transform: uppercase;" class="profile-title"><%=rf.getFname()%>
								<%=rf.getLname()%></h3>

						</div>
					</div>
				</div>
			</div>

			<a href="#" class="toggle-menu"><i class="fa fa-bars"></i></a>
			<div class="main-navigation responsive-menu">
				<ul class="navigation">
					<li><a href="#top"><i class="fa fa-globe"></i>Welcome</a></li>
					<li><a href="#about"><i class="fa fa-pencil"></i>Edit
							profile</a></li>
					<li><a href="#projects"><i class="fa fa-paperclip"
							id="Report" name="Report" onclick="rs()"></i>PDF Report</a></li>
					<li><a href="#logout"><i class="fa fa-link"></i>Logout</a></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- SIDEBAR -->
	<div class="sidebar-menu hidden-xs hidden-sm">
		<div class="top-section">
			<div class="profile-image">
				<img src="<%=rf.getPhoto()%>" alt="Volton">
			</div>

			<h3 style="text-transform: uppercase;" class="profile-title"><%=rf.getFname()%>
				<%=rf.getLname()%></h3>
			<p class="profile-description"><%=rf.getEmail()%></p>
		</div>

		<%
			}
		%>
		<div class="main-navigation">
			<ul class="navigation">
				<li><a href="#top"><i class="fa fa-globe"></i>Welcome</a></li>
				<li><a href="#about"><i class="fa fa-pencil"></i>Edit
						profile</a></li>
				<li><a href="#projects" onclick="rs()"><i
						class="fa fa-paperclip"></i>PDF Report</a></li>

				<li><a href="#logout"><i class="fa fa-link"></i>Logout</a></li>

			</ul>
		</div>
		<!-- .main-navigation -->

	</div>
	<!-- .sidebar-menu -->


	<div class="main-content">
		<div class="fluid-container">

			<div class="content-wrapper">
				<div class="page-section" id="top">
					<h4 class="widget-title">welcome</h4>

					<%@include file="calendar.jsp"%>




				</div>


				<div class="page-section" id="about">
					<div class="row">
						<div class="col-md-12">
							<h4 class="widget-title">Edit</h4>

							<h1 style="color: red;">Add your Information for more
								features</h1>



							<!-- begin row -->
							<div class="row">
								<!-- begin col-12 -->
								<div class="col-md-12">
									<!-- begin panel -->
									<div class="panel panel-inverse">
										<div class="panel-heading">
											<div class="panel-heading-btn">
												<a href="javascript:;"
													class="btn btn-xs btn-icon btn-circle btn-default"
													data-click="panel-expand"><i class="fa fa-expand"></i></a>
												<a href="javascript:;"
													class="btn btn-xs btn-icon btn-circle btn-success"
													data-click="panel-reload"><i class="fa fa-repeat"></i></a>
												<a href="javascript:;"
													class="btn btn-xs btn-icon btn-circle btn-warning"
													data-click="panel-collapse"><i class="fa fa-minus"></i></a>
												<a href="javascript:;"
													class="btn btn-xs btn-icon btn-circle btn-danger"
													data-click="panel-remove"><i class="fa fa-times"></i></a>
											</div>
											<h4 class="panel-title">ADD Your Details</h4>
										</div>
										<div class="panel-body">
											<form action="tempr" data-parsley-validate="true"
												name="form-wizard">
												<div id="wizard">
													<ol>
														<li>Identification <small>Your Information</small>
														</li>
														<li>Contact Information <small>So we can
																contact you</small>
														</li>
														<li>Login <small>Update yo Username &
																Password</small>
														</li>
														<li>Completed <small>Thank you</small>
														</li>
													</ol>
													<!-- begin wizard step-1 -->
													<div class="wizard-step-1">
														<fieldset>
															<legend class="pull-left width-full">Identification</legend>
															<!-- begin row -->
															<div class="row">
																<!-- begin col-4 -->
																<div class="col-md-4">
																	<div class="form-group block1">
																		<label>First Name</label> <input type="text"
																			name="firstname" placeholder="Rohit"
																			class="form-control"
																			data-parsley-group="wizard-step-1" required />
																	</div>
																</div>

																<!-- end col-4 -->
																<!-- begin col-4 -->
																<div class="col-md-4">
																	<div class="form-group">
																		<label>Last Name</label> <input type="text"
																			name="lastname" placeholder="Shelar"
																			class="form-control"
																			data-parsley-group="wizard-step-1" required />
																	</div>
																</div>
																<!-- end col-4 -->
																<!-- begin col-4 -->
																<div class="col-md-4">
																	<div class="form-group">
																		<label>Branch you Prefer</label> <select
																			class="form-control m-b" name="account">
																			<option>Nahre</option>
																			<option>Karve Nagar</option>
																			<option>Akurdi</option>

																		</select>
																	</div>
																</div>
																<!-- end col-4 -->
															</div>
															<!-- end row -->
														</fieldset>
													</div>
													<!-- end wizard step-1 -->
													<!-- begin wizard step-2 -->
													<div class="wizard-step-2">
														<fieldset>
															<legend class="pull-left width-full">Contact
																Information</legend>
															<!-- begin row -->
															<div class="row">
																<!-- begin col-6 -->
																<div class="col-md-6">
																	<div class="form-group">
																		<label>Phone Number</label> <input type="text"
																			name="phone" placeholder="8956185965"
																			class="form-control"
																			data-parsley-group="wizard-step-2"
																			data-parsley-type="number" required />
																	</div>
																</div>
																<!-- end col-6 -->
																<!-- begin col-6 -->
																<div class="col-md-6">
																	<div class="form-group">
																		<label>Email Address</label> <input type="email"
																			name="email" placeholder="rohitpshelar@yahoo.com"
																			class="form-control"
																			data-parsley-group="wizard-step-2"
																			data-parsley-type="email" required />
																	</div>
																</div>
																<!-- end col-6 -->
															</div>
															<!-- end row -->
														</fieldset>
													</div>
													<!-- end wizard step-2 -->
													<!-- begin wizard step-3 -->
													<div class="wizard-step-3">
														<fieldset>
															<legend class="pull-left width-full">Login</legend>
															<!-- begin row -->
															<div class="row">
																<!-- begin col-4 -->
																<div class="col-md-4">
																	<div class="form-group">
																		<label>Username</label>
																		<div class="controls">
																			<input type="text" name="username"
																				placeholder="rohitshelar" class="form-control"
																				data-parsley-group="wizard-step-3" required />
																		</div>
																	</div>
																</div>
																<!-- end col-4 -->
																<!-- begin col-4 -->
																<div class="col-md-4">
																	<div class="form-group">
																		<label>Pasword</label>
																		<div class="controls">
																			<input type="password" name="password"
																				placeholder="Your password" class="form-control"
																				data-parsley-group="wizard-step-3" required />
																		</div>
																	</div>
																</div>
																<!-- end col-4 -->
																<!-- begin col-4 -->
																<div class="col-md-4">
																	<div class="form-group">
																		<label>Confirm Pasword</label>
																		<div class="controls">
																			<input type="password" name="password2"
																				placeholder="Confirmed password"
																				class="form-control" required />
																		</div>
																	</div>
																</div>
																<!-- end col-6 -->
															</div>
															<!-- end row -->
														</fieldset>
													</div>
													<!-- end wizard step-3 -->
													<!-- begin wizard step-4 -->
													<div>
														<div class="jumbotron m-b-0 text-center">
															<h1>Login Successfully</h1>
															<p>Your new Password will be sent on mail.</p>
															<p>
																<a class="btn btn-success btn-lg" role="button"><input
																	type="submit" role="button"></a>
															</p>
														</div>
													</div>
													<!-- end wizard step-4 -->
												</div>
											</form>
										</div>
									</div>
									<!-- end panel -->
								</div>
								<!-- end col-12 -->
							</div>
							<!-- end row -->




							<div class="page-section" id="logout">

								<div class="welcome-text">
									<h3 style="color: black; font-size: xx-large;">Thank You</h3>
									<h5 style="color: black; font-size: xx-large;">
										Click here to<a href="login.jsp"> logout</a>
									</h5>
									<br> <br> <br> <br> <br> <br> <br>
									<br> <br> <br> <br> <br> <br> <br>
									<br> <br> <br> <br> <br>
								</div>
							</div>
						</div>
					</div>
				</div>


				<!-- ================== BEGIN BASE JS ================== -->
				<script src="assets/plugins/jquery/jquery-1.9.1.min.js"></script>
				<script src="assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
				<script src="assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
				<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
				<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
				<script src="assets/plugins/jquery-cookie/jquery.cookie.js"></script>
				<!-- ================== END BASE JS ================== -->

				<!-- ================== BEGIN PAGE LEVEL JS ================== -->
				<script src="assets/plugins/parsley/dist/parsley.js"></script>
				<script src="assets/plugins/bootstrap-wizard/js/bwizard.js"></script>
				<script src="assets/js/form-wizards-validation.demo.min.js"></script>
				<script src="assets/js/apps.min.js"></script>
				<!-- ================== END PAGE LEVEL JS ================== -->

				<script>
		$(document).ready(function() {
			App.init();
			FormWizardValidation.init();
		});
	</script>





				<!-- ================== BEGIN PAGE LEVEL JS ================== -->
				<script
					src="assets/plugins/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
				<script
					src="assets/plugins/bootstrap3-editable/inputs-ext/address/address.js"></script>
				<script
					src="assets/plugins/bootstrap3-editable/inputs-ext/typeaheadjs/lib/typeahead.js"></script>
				<script
					src="assets/plugins/bootstrap3-editable/inputs-ext/typeaheadjs/typeaheadjs.js"></script>
				<script
					src="assets/plugins/bootstrap3-editable/inputs-ext/wysihtml5/wysihtml5.js"></script>
				<script
					src="assets/plugins/bootstrap-wysihtml5/lib/js/wysihtml5-0.3.0.js"></script>
				<script
					src="assets/plugins/bootstrap-wysihtml5/src/bootstrap-wysihtml5.js"></script>
				<script
					src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
				<script
					src="assets/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
				<script src="assets/plugins/select2/select2.min.html"></script>
				<script src="assets/plugins/mockjax/jquery.mockjax.js"></script>
				<script src="assets/plugins/moment/moment.min.js"></script>
				<script src="assets/js/form-editable.min.js"></script>
				<script src="assets/js/apps.min.js"></script>
				<!-- ================== END PAGE LEVEL JS ================== -->

				<script>
		$(document).ready(function() {
			App.init();
			FormEditable.init();
		});
	</script>
</body>
</html>