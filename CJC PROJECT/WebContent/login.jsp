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
<script type="text/javascript">
function validi(){
var name = document.mylog.un.value;
var pw = document.mylog.pw.value;

if(name==""){
alert("Name cant be blank");
return false;

}else if(pw==""){
alert("Password cant be blank");
return false;

}
} 
</script>
<body>
	<!--WRAPPER-->
	<div id="wrapper" style="position: absolute;">

		<!--SLIDE-IN ICONS-->
		<div class="user-icon"></div>
		<div class="pass-icon"></div>
		<!--END SLIDE-IN ICONS-->


		<form action="log" method="get" class="login-form" name="mylog"
			onsubmit="return validi() ">
			<div class="header">
				<h1 align="center">Login Form</h1>
				<br>
				<br>

			</div>
			<div class="content">
				<input type="text" class="input username" name="un" value="Username"
					onfocus="this.value=''"> <input type="password"
					class="input password" name="pw" value="Password"
					onfocus="this.value=''">
				<%
					String s=(String) request.getAttribute("msg");
						
					if(s!=null) 
					{
					%>
				<h4 style="color: red"><%=s%></h4>
				<%} %>


			</div>
			<div class="footer">
				<input type="submit" value="Login" class="button" /> <a
					class="register" href="reg.jsp" value="Register">Register</a> <a
					class="register" href="ForgotPassword.jsp" value="Forgot Password">Forgot
					Password</a>
			</div>
		</form>
	</div>
	<div class="gradient" style="position: relative; widows: inherit;"></div>
</body>
</html>
