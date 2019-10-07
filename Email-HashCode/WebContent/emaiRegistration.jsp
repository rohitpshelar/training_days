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
	background: #f4f4f4;
}
</style>
</head>
<body>
	<div style="max-width: 390px; padding: 5px; margin: auto;">
		<h2 style="text-align: center">Register Here</h2>
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
		<form class="form-horizontal" id="formRegister"
			data-toggle="validator" role="form">
			<div class="form-group">
				<label for="inputEmail" class="control-label">Email</label> <input
					name="inputEmail"
					pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"
					class="form-control" id="inputEmail" placeholder="Enter Email"
					data-error="Enter valid Email" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="inputFirstName" class="control-label">First Name</label>
				<input pattern="[A-Za-z0-9]{1,20}" name="inputFirstName"
					class="form-control" id="inputFirstName"
					placeholder="Enter First Name"
					data-error="First name should not be null. It should be less than 20 characters. Use only A-Z, a-z, 0-9 charecters"
					required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="inputLastName" class="control-label">Last Name</label> <input
					pattern="[A-Za-z0-9]{1,20}" name="inputLastName"
					class="form-control" id="inputLastName"
					placeholder="Enter Last Name"
					data-error="last name should not be null. It should be less than 20 characters. Use only A-Z, a-z, 0-9 charecters"
					data-toggle="tooltip" data-placement="right" required>
				<div class="help-block with-errors"></div>

			</div>
			<div class="form-group">
				<label for="inputLastName" class="control-label">Branch</label> <select
					id="branch" name="branch">
					<optgroup label="Select">
						<option label="Nahre">
						<option label="Karve Nagar">
						<option label="Akurdi">
					</optgroup>
				</select>
				<div class="help-block with-errors"></div>
			</div>

			<div class="form-group">
				<label for="inputContact No" class="control-label">Contact
					No.</label> <input type="text" pattern="[0-9]{10,10}"
					name="input Contact No." class="form-control" id="contact"
					placeholder="Enter Contact No."
					data-error="Contact No. should not be null. It should be 10 Numbers . Use only 0-9 charecters"
					required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="inputAddress" class="control-label">Address</label> <input
					type="text" name="address" class="form-control" id="address"
					placeholder="Enter address" data-error="It should not be empty"
					required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<button style="width: 100%" type="submit"
					class="btn btn-default btn-primary">Register</button>
			</div>
		</form>
		<div id="blockUiDiv">
			<img src="wave.svg" />
		</div>
		<div id="blockUiBackdrop"></div>
	</div>
	<script>
$(function () {
	$('#formRegister').validator().on('submit', function (e) {
		  if (e.isDefaultPrevented()) {
		    // handle the invalid form...
		  } else {
			  blockUi();
		    // everything looks good!
			  $.post("RegisterEmail", $( "#formRegister").serialize(), function( data ) {
				  var jdata = JSON.parse(data);
				  if(jdata.code == -1) {
					  $("#errorField .message").text(jdata.message);
					  $("#errorField").show();
					  $("#successField").hide();
				  } else {
					  $("#successField .message").text(jdata.message);
					  $("#errorField").hide();
					  $("#successField").show();
					  $("#formRegister").hide();
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