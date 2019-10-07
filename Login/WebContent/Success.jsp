
<jsp:directive.page import="java.util.ArrayList"/>
<html>
	<head>
<h1 align="center" style="color: red">Success</h1>
	</head>

	<body >
	
<table><tr><td>rohit</td><td>shelar</td>
</tr>



<%


 ArrayList<String> al=(ArrayList<String>) request.getAttribute("data");
 
 for(String s:al)
 {
 %>

<td>
<%= s%>

<%} %>
</table>
	
	</body>
</html>
