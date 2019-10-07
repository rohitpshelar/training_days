<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajax</title>

<script type="text/javascript">
function xyz(){
	var req=new XMLHttpRequest();
	var fn=document.getElementById('fn');
	//alert("Username "+fn.value+" Already exist");
	var url="log?fn="+fn.value;
	req.open("get", url, true);
	req.send();
	//alert("after send")
	req.onreadystatechange = function(){
	if (req.readyState==4 && req.status==200) {
		
	//alert("inside if")
	document.getElementById("display").innerHTML=req.responseText;
	//alert("end if")
	}
	}
}

</script>

</head>
<body>
Roll no<input type="text" name="r" id="r" >
<br>First name<input type="text" name="fn" id="fn" onchange="xyz()">
<div style="color: red" id="display" ></div>
User Name<input type="text" name="un" id="un"> 

<br>Password<input type="password" name="pw" id="pw"> 

<input type="submit" value="Submit">
</body>
</html>