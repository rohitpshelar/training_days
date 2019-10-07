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
		
		function rs()
		{	
			var id=document.getElementsByName("r");
			
			
			var aa=id;
			alert(aa);
			document.location.href="rs?rs="+aa;
	
}		
		
function editreg()
		{	
		var id=document.getElementsByName("r");
		for(var i=0;i<id.length;i++){
		if(id[i].checked){
		var aa=id[i].value;
		break;
		}
		}	
		document.location.href="edits?radio="+aa;
}

function delreg()
		{	
		var id=document.getElementsByName("r");
		for(var i=0;i<id.length;i++){
		if(id[i].checked){
		var aa=id[i].value;
		break;
		}
		}	
		document.location.href="dels?radio="+aa;
}
		</script>
		
	</head>
	<body>
	<div style="background-color:gray;">
		<h2 align="center" style="color:white;">
			Success Page
		</h2>
		</div>
		<div align="center">
			<table border="2"  align="center">
				<tr style="font: bold">
					<td>
						Select
					</td>
					<td>
						Registration ID
					</td>
					<td>
						Image
					</td>
					<td>
						First Name
					</td>
					<td>
						Last Name
					</td>
					<td>
						Gender
					</td>
					<td>
						Qualification
					</td>
					<td>
						Address
					</td>
					<td>
						Language
					</td>
					<td>
						User Name
					</td>
					<td>
						Password
					</td>
				</tr>
				<%
					ArrayList al = (ArrayList) request.getAttribute("data");

					Iterator itr = al.iterator();
					while (itr.hasNext()) {
						RegForm rf = (RegForm) itr.next();
				%>
				<tr align="center">
					<td>
						<input type="radio" name="r" id="r" checked="checked"
							value="<%=rf.getRegid()%>">
					</td>
					<td>
						<%=rf.getRegid()%>
					</td>
					<td>
						<img src="<%=rf.getPhoto()%>" width="60" height="60"
							class="img-thumbnail" />
					</td>
					<td>
						<%=rf.getFname()%>
					</td>
					<td>
						<%=rf.getLname()%>
					</td>
					<td>
						<%=rf.getGender()%>
					</td>
					<td>
						<%=rf.getQual()%>
					</td>
					<td>
						<%=rf.getAdder()%>
					</td>
					<td>
						<%=rf.getLang()%>
					</td>
					<td>
						<%=rf.getUname()%>
					</td>
					<td>
						<%=rf.getPass()%>
					</td>
				</tr>
				<%
				}
				%>
			</table>

			<table align="center">
				<tr>
					<td>
						<a href="reg.jsp"><input type="submit" name="i" value="Insert"
								id="i"> </a>
					</td>
					<td>
						<input type="button" name="e" value="Edit" id="e"
							onclick="editreg()">
					</td>
					<td>
						<input type="button" name="d" value="Delete" id="d"
							onclick="delreg()">
					</td>
					
					<td>			
					<input type="button" value="Convert Result to PDF" id="rs"
							name="rs" onclick="rs()">					
					</td>
					
					<td>
						<a href="login.jsp"><input type="button" name="b" value="Logout"
								id="b"> </a>
					</td>
					
				</tr>
			</table>
		</div>
		
	</body>
</html>
