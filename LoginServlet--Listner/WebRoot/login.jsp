
<html>
	<head>
		<h1 align="center" style="color: red">
			Login Page
		</h1>
	</head>
	<script type="text/javascript">
function validi(){
var name = document.mylog.un.value;
var pw = document.mylog.pw.value;

if(name==""){
alert("Name cant be blank");
return false;

}else if(pw==""){
alert("Password cant be blank");
return false;

}
} 
</script>
	<body>

		<form action="log" method="get" name="mylog"
			onsubmit="return validi()">
			<table align="center">
				<tr>
					<td>
						Username:
					</td>
					<td>
						<input type="text" name="un" maxlength="8">
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
					<td>
						<input type="password" name="pw" maxlength="8"">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Submit">
					<td>
					<td align="left">
						<a href="reg.jsp">SignUp</a>
					<td>
				</tr>
			</table>
		</form>

	</body>
</html>
