<jsp:directive.page import="java.util.ArrayList" />
<jsp:directive.page import="java.util.Iterator" />
<jsp:directive.page import="com.cjc.model.RegForm" />
<jsp:directive.page import="java.io.FileOutputStream" />
<jsp:directive.page import="java.sql.Blob" />

<html>
<head>

<title>Success</title>
<script language="JavaScript" type="text/javascript">
	window.history.forward(1);
</script>






<script type="text/javascript">
	function rs() {
		var id = document.getElementsByName("r");

		var aa = id;
		alert(aa);
		document.location.href = "rs?rs=" + aa;

	}

	function editreg() {
		var id = document.getElementsByName("r");
		for (var i = 0; i < id.length; i++) {
			if (id[i].checked) {
				var aa = id[i].value;
				break;
			}
		}
		document.location.href = "edits?radio=" + aa;
	}

	function delreg() {
		var id = document.getElementsByName("r");
		for (var i = 0; i < id.length; i++) {
			if (id[i].checked) {
				var aa = id[i].value;
				break;
			}
		}
		document.location.href = "dels?radio=" + aa;
	}
</script>

</head>
<body>
	<div style="background-color: gray;">
		<h2 align="center" style="color: white;">Success Page</h2>
	</div>
	<table>
		<%
				ArrayList al = (ArrayList) request.getAttribute("data");

				Iterator itr = al.iterator();
				while (itr.hasNext()) {
					RegForm rf = (RegForm) itr.next();
			%>
		<tr align="left">
		<tr>
			<td><input hidden="true" ; type="radio" name="r" id="r"
				checked="checked" value="<%=rf.getRegid()%>"></td>
		</tr>
		<tr>
			<td><p hidden="true";><%=rf.getRegid()%></p></td>
		<tr>
			<td align="center"><img src="<%=rf.getPhoto()%>" width="60"
				height="60" class="img-thumbnail" /></td>
		</tr>
		<td><p style="text-transform: uppercase;"><%=rf.getFname()%>
				<%=rf.getLname()%></p></td>
		<tr>
			<td><%=rf.getEmail()%></td>
		</tr>
		<%
				}
			%>
	</table>

	<table align="left">
		<tr>
			<td><a href="reg.jsp"><input type="submit" name="i"
					value="Insert" id="i"> </a></td>
		<tr>
			<td><input type="button" name="e" value="Edit" id="e"
				onclick="editreg()"></td>
		<tr>
			<td><input type="button" name="d" value="Delete" id="d"
				onclick="delreg()"></td>
		<tr>
			<td><input type="button" value="Convert Result to PDF" id="rs"
				name="rs" onclick="rs()"></td>
		<tr>
			<td><a href="login.jsp"><input type="button" name="b"
					value="Logout" id="b"> </a></td>
	</table>
	</div>

</body>
</html>
