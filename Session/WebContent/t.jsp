<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%=session %>

</head>
<body>
<div align="center">
<form action="logt" method="get">
Third Data<input type="text" name="t3" id="t3">
<input type="submit" value="Submit">
<%=session.getAttribute("t1") %>
<%=session.getAttribute("t2") %>
</form>
</body>
</html>