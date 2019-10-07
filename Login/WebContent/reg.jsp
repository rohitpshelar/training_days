
<html>
	<head>
		<h1 align="center" style="color: red">
			Registration
		</h1>
	</head>

	<body>


		<form action="reg">
			<table align="center">
				<tr>
					<td>
						First Name:
					</td>
					<td>
						<input type="text" name="fn">
					</td>
				</tr>
				<tr>
					<td valign="top" name>
						Gender
						<br>
					</td>
					<td valign="top">
					
						<input type="radio" checked="true" value="male" name="sex">
						male&nbsp;&nbsp;&nbsp;
						<input type="radio" value="female" name="sex">
						Female
					</td>
				
				</tr>
				<tr>
					<td>
						Last Name:
					</td>
					<td>
						<input type="text" name="ln">
					</td>
					<br>
				</tr>
				<tr>
					<td valign="top">
						Qualification
						<br>
					</td>
					<td valign="top"><select size="2"  name="qual"> 
							<option selected="selected" value="bca"> 
								BCA 
							</option> 
							<option value="mca"> 
								MCA 
							</option> 
							<option value="bcs"> 
								BCS 
							</option> 
						</select></td><td valign="top">
						
					<br></td>
				</tr>
				<tr>
					<td>
						User Name:
					</td>
					<td>
						<input type="text" name="una">
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
					<td>
						<input type="password" name="pwd">
					</td>
				</tr>
				<tr>
					<td>
						Address:
					</td>
					<td>
						<input type="text" name="add">
					</td>
				</tr>
				<%--<tr><td valign="top">Photo<br></td><td valign="top"><<input type="file" name="photo" ><br></td></tr><tr>--%>
					<td>
						<input type="submit" value="Submit">
					<td>
				</tr>
			</table>
		</form>
		<form action="db">
			<
			<h1 align="center">
				<input type="submit" value="DATABASE">
			</h1>
		</form>
	</body>
</html>
