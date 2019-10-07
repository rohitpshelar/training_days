<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:directive.page import="com.DaoIMPL.DaoIMPL" />
<jsp:directive.page import="java.sql.ResultSet" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajax</title>


<script type="text/javascript">
	function showState(stateId) {
		var reg = new XMLHttpRequest();
		alert(stateId)
		var url = "log?stateId=" + stateId;
		reg.open("GET", url, true);
		reg.send();
		reg.onreadystatechange = function() {
			if (reg.readyState == 4 && reg.status == 200) {
				document.getElementById("display").innerHTML = reg.responseText;
			}
		}
	}
	function showCity(cityId) {
		var reg = new XMLHttpRequest();
		var url = "logc?cityId=" + cityId;
		reg.open("GET", url, true);
		reg.send();
		reg.onreadystatechange = function() {
			if (reg.readyState == 4 && reg.status == 200) {
				document.getElementById("displayc").innerHTML = reg.responseText;
			}
		}
	}
</script>
<h2 align="center" style="color: white;">Select Country => State =>
	City</h2>
</head>
<body style="background-color: gray;">
	<div style="background-color: yellow;">
		<table align="center">
			<tr align="center">
				<td>Country ==></td>
				<td>State ==></td>
				<td>City</td>
			</tr>
			<tr>
				<td><select name="country" onchange="showState(this.value)">
						<option selected="selected">*Select*</option>
						<%
							DaoIMPL d = new DaoIMPL();
							ResultSet rs = d.getCountry();
							while (rs.next()) {
						%>
						<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
						<%
							}
						%>
				</select></td>
				<td>
					<div style="color: red" id="display"></div>
				</td>
				<td>
					<div style="color: red" id="displayc"></div>
				</td>
			</tr>
		</table>
</body>
</html>
