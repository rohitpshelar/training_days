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
		style="max-width: 400px; padding: 10px 20px; margin: auto; margin-top: calc(50vh - 220px);">
		<h3 style="text-align: center">Forgot Password</h3>
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
		<form class="form-horizontal" id="formForgotPassword"
			data-toggle="validator" role="form">
			<div class="form-group">
				<label for="inputEmail" class="control-label">Email</label> <input
					name="inputEmail" type="email" class="form-control" id="inputEmail"
					placeholder="Enter Email" data-error="Enter valid Email" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<button style="width: 100%" type="submit"
					class="btn btn-default btn-primary">Send Verification Link</button>
			</div>
		</form>
		<div id="blockUiDiv">
			<img src="wave.svg" />
		</div>
		<div id="blockUiBackdrop"></div>
	</div>
	<script>
$(function () {
	$('#formForgotPassword').validator().on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
		    // handle the invalid form...
		  } else {
			  blockUi();
		    // everything looks good!
			  $.post("ForgotPassword", $( "#formForgotPassword").serialize(), function( data ) {
				  var jdata = JSON.parse(data);
				  if(jdata.code == -1) {
					  $("#errorField .message").text(jdata.message);
					  $("#errorField").show();
					  $("#successField").hide();
				  } else {
					  $("#successField .message").text(jdata.message);
					  $("#errorField").hide();
					  $("#successField").show();
					  $("#formForgotPassword").hide();
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