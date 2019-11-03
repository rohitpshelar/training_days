<%--<jsp:useBean id="ivalid" class="com.cjc.LoginServlet" scope="request">
	<jsp:setProperty name="ivalid" / property="un" />
</jsp:useBean>

--%>
<html>
	<head>
<title>Invalid</title>
		<!--META-->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Login Form</title>

		<!--STYLESHEETS-->
		<link href="css/style.css" rel="stylesheet" type="text/css" />

		<!--SCRIPTS-->
		<script type="text/javascript"
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
		<!--Slider-in icons-->


	</head>

	<body>
		<div id="wrapper">

			<div class="content">
				<h1 class="login-form" align="center" style="color: red">
					IN VALID Login
				</h1>
				<h1 align="center" style="color: black; text-transform: capitalize">
					<%=request.getParameter("un")%>
				</h1>
			</div>
			<h1 align="center" style="color: red;">
				<div class="footer">
					<a href="login.jsp">Login </a>
			
			<h1 align="center" style="color: red;">
				<a href="login.jsp">BACK</a>
			</h1>
			</div>
		</div>

		
	</body>
</html>
