<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h2 style="color: red;">In side Account</h2>
<div align="center">
<form action="logs" method="get">
Second Data<input type="text" name="t2" id="t2">
<input type="submit" value="Submit">

<%=session.getAttribute("t1") %>
<%=session%>

 
</form></div>
</body>
</html>