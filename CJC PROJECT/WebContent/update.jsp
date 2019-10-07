<jsp:directive.page import="java.util.ArrayList" />
<jsp:directive.page import="java.util.Iterator" />
<jsp:directive.page import="com.cjc.model.RegForm" />
<html>
<head>
<title>UPDATE</title>
<script type="text/javascript">		
function updatedreg()
{
	var id=document.getElementsByName("r");
	for(var i=0;i<id.length;i++)
	{
		if(id[i].checked)
		{
			var aa=id[i].value;
			break;
		}
	}	
	document.location.href="editeds?radio="+aa;
}
		</script>
</head>
<body>
	<h2 align="center" style="color: red;">UPDATE PAGE</h2>
	<form action="editeds">
		<table align="center">
			<%
					ArrayList al = (ArrayList) request.getAttribute("data");
					Iterator itr = al.iterator();
					while (itr.hasNext()) {
						RegForm rf = (RegForm) itr.next();
				%>
			<tr>
				<td><input type="radio" checked="checked" name="r" id="r"
					value="<%=rf.getRegid()%>"></td>
				<td><%=rf.getRegid()%></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fn" value="<%=rf.getFname()%>">
				</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="ln" value="<%=rf.getLname()%>">
				</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="<%=rf.getEmail()%>">
				</td>
			</tr>
			<tr>
				<td valign="top">Gender <br>
				</td>
				<td valign="top">
					<% if("0".equals(rf.getGender()))
							{
							String s="checked";
							%> <input type="radio" checked="s" value="0" name="gen">
					male&nbsp;&nbsp;&nbsp; <input type="radio" value="1" name="gen">
					Female <%}  if("1".equals(rf.getGender()))
							{
							String s="checked";
							%> <input type="radio" value="0" name="gen">
					male&nbsp;&nbsp;&nbsp; <input type="radio" checked="s" value="1"
					name="gen"> Female <%} %>
				</td>
			</tr>
			<tr>
				<td valign="top">Qualification <br>
				</td>

				<td valign="top"><select size="2" name="qual">
						<% if("bca".equals(rf.getQual()))
							{
							String s="selected";
							%>
						<option selected="s" value="bca">BCA</option>
						<option value="mca">MCA</option>
						<option value="bcs">BCS</option>
						<% } if("mca".equals(rf.getQual()))
							{
							String s="selected";
							%>
						<option value="bca">BCA</option>
						<option selected="s" value="mca">MCA</option>
						<option value="bcs">BCS</option>
						<% } if("bcs".equals(rf.getQual()))
							{
							String s="selected";
							%>
						<option value="bca">BCA</option>
						<option value="mca">MCA</option>
						<option selected="s" value="bcs">BCS</option>

						<% }%>
				</select></td>
				<td valign="top"><br></td>
			</tr>

			<tr>

				<td>Language</td>
				<%
						String str = rf.getLang();
						String English="hi",Hindi="hi",Marathi="hi";
							String[] str1 = str.split(", ");
							for (int ii = 0; ii < str1.length; ii++) {
								System.out.println("Language :" + str1[ii]);
								if(str1[ii].equals("English")){
									English = str1[ii];
								}if(str1[ii].equals("Hindi")){
									Hindi = str1[ii];
								}if(str1[ii].equals("Marathi")){
									Marathi = str1[ii];
								}
							}
							System.out.println("values : "+English+Hindi+Marathi);
						%>
				<td><input type="checkbox" name="lang" value="English"
					<% if(English.equals("English")){%> checked <%} %>> English
					<input type="checkbox" name="lang" value="Hindi"
					<%if(Hindi.equals("Hindi")){%> checked <%} %>> Hindi <input
					type="checkbox" name="lang" value="Marathi"
					<% if(Marathi.equals("Marathi")){%> checked <%} %>> Marathi
				</td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="add" value="<%=rf.getAdder()%>">
				</td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="un" value="<%=rf.getUname()%>">
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pw" value="<%=rf.getPass()%>">
				</td>
			</tr>
			<tr>
				<%--<tr><td valign="top">Photo<br></td><td valign="top"><<input type="file" name="photo" ><br></td></tr><tr>--%>
				<td></td>
				<td><input type="submit" value="UPDATE"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
	<%}%>
</body>
</html>
