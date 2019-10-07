
<jsp:directive.page import="com.cjc.daoImpI.Dao"/>
<jsp:directive.page import="java.sql.ResultSet"/>
<html>
	<head>
		<title>Registration</title>
		<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Registration</title>

<!--STYLESHEETS-->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--SCRIPTS-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
	
	<script type="text/javascript">
function unameCheck(){
 var username=document.getElementsByName("una");

 <%
 Dao d=new Dao();
 ResultSet rs=d.GetLoginUsername();
 while(rs.next()){
 %>
 var check=<% rs.getString(1);%> 

if(username==check) 
{
alert("username is Already exists");
}

<%}%>
}
</script>
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
}
</script>
</head>
	<body>
<!--WRAPPER-->
<div id="wrapper">

		<form action="reg" class="login-form">
		
		<div class="header">
    <!--TITLE--><h3>Registration</h3><!--ENDTITLE-->
    </div>
    <div class="content">
			<!--USERNAME--><input name="fn" type="text" class="input username" value="First Name" onfocus="this.value=''" /><!--END USERNAME-->
			<!--USERNAME--><input name="ln" type="text" class="input username" value="Last Name" onfocus="this.value=''" /><!--END USERNAME-->
			
					<h5 align="center" style="color: blue;">GENDER</h5>
						<input type="radio" checked="checked" value="0" name="sex">
						Male&nbsp;&nbsp;&nbsp;
						<input type="radio" value="1" name="sex">
						Female
				<h5 align="center" style="color: blue;">QUALIFICATION</h5>
				
	<select  size="2"  name="qual" > 
							<option selected="selected" value="bca"> 
								BCA 
							</option> 
							<option value="mca"> 
								MCA 
							</option> 
							<option value="bcs"> 
								BCS 
							</option> 
						</select>
				
				<h5 align="center" style="color: blue;">LANGUAGE</h5>
			
			
			
			    <input type="checkbox" name="lang" value="English"> English 
			<input type="checkbox" name="lang" value="Hindi"  > Hindi 
			<input type="checkbox" name="lang" value="Marathi"> Marathi 
				
				
					<!--add--><input name="add" type="text" class="input username" value="Adderss" onfocus="this.value=''" /><!--add-->
	
			<!--USERNAME--><input name="una" type="text" class="input username" value="Username" onfocus="this.value=''" onkeydown="unameCheck()"  /><!--END USERNAME-->
			
				
			
				 <!--PASSWORD--><input name="pwd" type="password" class="input password" value="Password" onfocus="this.value=''" /><!--END PASSWORD-->
		<br>	Photo<input type="file" name="photo"  >
			</div>
				
				 <div class="footer">	
						<input type="submit" class="button" value="Submit">
						<a class="register" href="login.jsp" >Back</a>
				</div>	
			
		</form>
	</div>
	<div class="gradient"></div>
	</body>
</html>
