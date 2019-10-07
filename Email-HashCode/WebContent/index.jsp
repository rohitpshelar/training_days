<html>
<head>
<title>Complete Java Classes</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/validator.min.js"></script>
<link rel="stylesheet" href="css/my-block-ui.css">
<script src="js/my-block-ui.js"></script>
<style>
.form-horizontal .control-label {
	margin-bottom: 5px;
}

.form-horizontal .form-group {
	margin-bottom: 5px;
	margin-left: 0px;
	margin-right: 0px;
}

body {
	background-color: #f4f4f4;
}
</style>

</head>
<body>
	<div
		style="max-width: 400px; padding: 10px 20px; margin: auto; margin-left: calc(50vh - 220px);">
		<h3 style="text-align: center">
			Welcome to <br>Complete Java Classes
		</h3>

		<div class="alert alert-danger" role="alert" id="errorField"
			style="display: none">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">Error:</span> <span class="message"></span>
		</div>

		<div class="alert alert-success" role="alert" id="successField"
			style="display: none">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<jsp:include page="hello.jsp"></jsp:include>
			<span class="sr-only">Success:</span> <span class="message"></span>
		</div>

		<div id="forLoginUser" style="display: none" align="left">
			<jsp:include page="hello.jsp"></jsp:include>
			Now you can access <br /> <a href="ChangePassword">Change
				Password</a> <br /> <a href="Logout">Logout</a> <br />
		</div>

		<form class="form-horizontal" id="formLogin" data-toggle="validator"
			role="form">
			<div class="form-group">
				<label for="inputEmail" class="control-label">Email</label> <input
					name="inputEmail" type="email" class="form-control" id="inputEmail"
					placeholder="Enter Email" data-error="Enter valid Email" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="control-label">Password</label> <input
					type="password" name="inputPassword" class="form-control"
					id="inputPassword" placeholder="Enter Password"
					data-error="Password should not be null" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="row" style="margin-bottom: 7px">
				<div class="col-sm-6" style="text-align: left">
					<a href="forgotPassword.jsp">Forgot password ?</a>
				</div>
				<div class="col-sm-6" style="text-align: right">
					<a href="emaiRegistration.jsp">Register</a>
				</div>
			</div>
			<div class="form-group">
				<button style="width: 100%" type="submit"
					class="btn btn-default btn-primary">Login</button>
			</div>
		</form>

	</div>
	<div id="blockUiDiv">
		<img src="373.gif" />
	</div>

	<div id="blockUiBackdrop"></div>
	+
	<script>
		$(function() {
			$('#formLogin').validator().on(
					'submit',
					function(e) {
						blockUi();
						if (e.isDefaultPrevented()) {
							// handle the invalid form...
						} else {
							// everything looks good!
							$.post(
									"Login",
									$("#formLogin").serialize(),
									function(data) {
										var jdata = JSON.parse(data);
										if (jdata.code == -1) {
											$("#errorField .message").text(
													jdata.message);
											$("#errorField").show();
											$("#successField").hide();
											$("#forLoginUser").hide();
										} else if (jdata.code == 0) {
											$("#successField .message").text(
													jdata.message);
											$("#errorField").hide();
											$("#successField").show();
											$("#formLogin").hide();
											$("#forLoginUser").show();
										}
									}).always(function() {
								unBlockUi();
							});
						}
						return false;
					});
		});
	</script>
</body>
</html>