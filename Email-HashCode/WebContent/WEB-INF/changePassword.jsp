<html>
<head>
<title>Email Registration</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
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
		style="max-width: 400px; padding: 10px 20px; margin: auto; margin-top: 30px;">
		<h3 style="text-align: center">Change Password</h3>
		<div class="alert alert-danger" role="alert" id="errorField"
			style="display: none">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">Error:</span> <span class="message"></span>
		</div>
		<div class="alert alert-success" role="alert" id="successField"
			style="display: none">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">Success:</span> <span class="message"></span>
		</div>
		<div id="loginUser" style="display: none">
			Now you can verify your password by <a href="index.html">Login</a>
		</div>
		<form class="form-horizontal" id="formChangePassword"
			data-toggle="validator" role="form">
			<div class="form-group">
				<label for="inputCurrentPassword" class="control-label">Current
					Password</label> <input type="password" pattern="[A-Za-z0-9@#$%!^&*]{6,30}"
					name="inputCurrentPassword" class="form-control"
					id="inputCurrentPassword" placeholder="Enter Current Password"
					data-error="Password should not be null. It should be greater than 6 and less than 30 characters . Use only A-Z, a-z, 0-9, @ # $ % ! ^ & * charecters"
					required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="control-label">New
					Password</label> <input type="password" pattern="[A-Za-z0-9@#$%!^&*]{6,30}"
					name="inputPassword" class="form-control" id="inputPassword"
					placeholder="Enter New Password"
					data-error="Password should not be null. It should be greater than 6 and less than 30 characters . Use only A-Z, a-z, 0-9, @ # $ % ! ^ & * charecters"
					required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="inputPassword1" class="control-label">Confirm
					New Password</label> <input type="password" name="inputPassword1"
					class="form-control" id="inputPassword1"
					data-match="#inputPassword" placeholder="Enter New Password Again"
					data-error="It should not be null and should match with above password"
					required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<button style="width: 100%" type="submit"
					class="btn btn-default btn-primary">Login</button>
			</div>
		</form>
		<div id="blockUiDiv">
			<img src="wave.svg" />
		</div>
		<div id="blockUiBackdrop"></div>
	</div>
	<script>
$(function () {
	$('#formChangePassword').validator().on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
		    // handle the invalid form...
		  } else {
			  blockUi();
		    // everything looks good!
			  $.post("ChangePassword", $( "#formChangePassword").serialize(), function( data ) {
				  var jdata = JSON.parse(data);
				  if(jdata.code == -1) {
					  $("#errorField .message").text(jdata.message);
					  $("#errorField").show();
					  $("#successField").hide();
					  $("#loginUser").hide();
				  } else {
					  $("#successField .message").text(jdata.message);
					  $("#errorField").hide();
					  $("#successField").show();
					  $("#formChangePassword").hide();
					  $("#loginUser").show();
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