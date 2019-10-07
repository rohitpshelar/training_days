<html>
<head>


<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login Form</title>

<!--STYLESHEETS-->
<link href="css/style.css" rel="stylesheet" type="text/css" />

<!--SCRIPTS-->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<!--Slider-in icons-->
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>

</head>

<body>
	<!--WRAPPER-->
	<div id="wrapper" style="top: 236px; height: 403px;">

		<!--SLIDE-IN ICONS-->
		<div class="user-icon"></div>
		<div class="pass-icon"></div>
		<!--END SLIDE-IN ICONS-->


		<form action="forgot" method="get" class="login-form" name="mylog"
			onsubmit="return validi() ">
			<div class="header">
				<h1 align="center">Forgot Password</h1>
				<p align="left" style="color: red;">Note*: Your NEW password
					will be sent on email
			</div>
			<div class="content">
				<input type="text" class="input username" name="email" value="email"
					onfocus="this.value=''">

			</div>
			<div class="footer">
				<input type="submit" value="Reset" class="button" />

			</div>
		</form>
	</div>
	<div class="gradient"></div>
</body>
</html>
