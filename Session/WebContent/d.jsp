<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%HttpSession sessions = request.getSession(false);
%>

<%=sessions %>
<%
		if(sessions==null){
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);	
			
		}
		
 %>
</head>
<body>
First data  =<%=session.getAttribute("t1") %><br>
Second Data =<%=session.getAttribute("t2") %><br>
Third Data=<%=session.getAttribute("t3") %>
</body>
</html>