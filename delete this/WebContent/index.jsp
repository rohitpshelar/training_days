<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



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
					<h4 class="panel-title">Form Wizards</h4>
				</div>
				<div class="panel-body">
					<form action="log" data-parsley-validate="true" name="form-wizard">
						<div id="wizard">
							<ol>
								<li>Identification <small>Lorem ipsum dolor sit
										amet, consectetur adipiscing elit.</small>
								</li>
								<li>Contact Information <small>Aliquam bibendum
										felis id purus ullamcorper, quis luctus leo sollicitudin.</small>
								</li>
								<li>Login <small>Phasellus lacinia placerat neque
										pretium condimentum.</small>
								</li>
								<li>Completed <small>Sed nunc neque, dapibus non
										leo sed, rhoncus dignissim elit.</small>
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
													name="firstname" placeholder="John" class="form-control"
													data-parsley-group="wizard-step-1" required />
											</div>
										</div>
										<!-- end col-4 -->
										<!-- begin col-4 -->
										<div class="col-md-4">
											<div class="form-group">
												<label>Middle Initial</label> <input type="text"
													name="middle" placeholder="A" class="form-control"
													data-parsley-group="wizard-step-1" required />
											</div>
										</div>
										<!-- end col-4 -->
										<!-- begin col-4 -->
										<div class="col-md-4">
											<div class="form-group">
												<label>Last Name</label> <input type="text" name="lastname"
													placeholder="Smith" class="form-control"
													data-parsley-group="wizard-step-1" required />
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
												<label>Phone Number</label> <input type="text" name="phone"
													placeholder="1234567890" class="form-control"
													data-parsley-group="wizard-step-2"
													data-parsley-type="number" required />
											</div>
										</div>
										<!-- end col-6 -->
										<!-- begin col-6 -->
										<div class="col-md-6">
											<div class="form-group">
												<label>Email Address</label> <input type="email"
													name="email" placeholder="someone@example.com"
													class="form-control" data-parsley-group="wizard-step-2"
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
													<input type="text" name="username" placeholder="johnsmithy"
														class="form-control" data-parsley-group="wizard-step-3"
														required />
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
														placeholder="Confirmed password" class="form-control" />
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
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
										Mauris consequat commodo porttitor. Vivamus eleifend, arcu in
										tincidunt semper, lorem odio molestie lacus, sed malesuada est
										lacus ac ligula. Aliquam bibendum felis id purus ullamcorper,
										quis luctus leo sollicitudin.</p>
									<p>
										<a class="btn btn-success btn-lg" role="button"><input
											type="submit"></a>
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
	</div>
	<!-- end #content -->






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






</body>
</html>