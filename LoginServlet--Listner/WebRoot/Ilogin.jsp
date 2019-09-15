<%--<jsp:useBean id="ivalid" class="com.cjc.LoginServlet" scope="request">
	<jsp:setProperty name="ivalid" / property="un" />
</jsp:useBean>

--%><html>
	<head>
		<h1 align="center" style="color: red">

			IN VALID Login</h1><h1 align="center" style="color: black; text-transform: capitalize"><%= request.getParameter("un")%></h1>

		
	</head>

	<body>
		<%--<jsp:getProperty name="ivalid" property="un" />
		--%><br>
		<h1 align="center" style="color: red">
		<a href="login.jsp">BACK</a></h1>
	</body>
</html>
