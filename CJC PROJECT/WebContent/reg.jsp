<jsp:directive.page import="com.cjc.daoImpI.Dao" />
<jsp:directive.page import="java.sql.ResultSet" />
<html>
<head>
<title>Registration</title>
<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Registration</title>

<!--STYLESHEETS-->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--SCRIPTS-->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>

<script type="text/javascript">
	
$(document).ready(function() {
	$('#fn').change(function(event) {
		var fn = $('#fn').val();
	
		$.get('un', {fn : fn}, function(responseText) {
			$('#display').html(responseText);
		});
	});
});
	
	</script>

<script type="text/javascript">
	
$(document).ready(function() {
	$('#b').click(function(event) {
		alert( 'Enter User Name*');
	});
});
	</script>


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
}
</script>
</head>
<body>
	<!--WRAPPER-->
	<div id="wrapper">

		<form action="reg" class="login-form">

			<div class="header">
				<!--TITLE-->
				<h3>Registration</h3>
				<!--ENDTITLE-->
			</div>
			<div class="content">
				<!--First Name-->
				First Name: <br>
				<input name="fn" pattern="{1,20}" type="text" class="input username"
					value="First Name" onfocus="this.value=''" required />
				<!--END First Name-->

				<br>

				<!--Last Name-->
				Last Name: <br>
				<input name="ln" type="text" class="input username"
					value="Last Name" onfocus="this.value=''" required="required" />
				<!--END Last Name-->
				<br>
				<!--Email-->
				Email: <br>
				<input name="email" type="text" class="input username" value="Email"
					onfocus="this.value=''" required="required" id="fn" />
				<!--END Email-->
				<br> <br>




			</div>
			<div class="footer">
				<div id="display">
					<input type="button" class="button" value="Submit" id="b">
				</div>
				<a class="register" href="login.jsp">Back</a>
			</div>
		</form>
	</div>
	<div class="gradient"></div>
</body>
</html>
