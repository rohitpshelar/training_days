<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function xyz(){
	var req=new XMLHttpRequest();
	var fn=document.getElementById('MH');
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

	<Table align="center" border="1">
		<Tr align="center">
			<td align="center">State</td>
			<td align="center">City</td>
			<td align="center">Place</td>
		</Tr>
		<Tr>
			<Td><select name="States">
					<option value="" selected>-:Select a State:-</option>
					<option value="MH" id="MH">Maharashtra</option>
					<option value="RJ" id="RJ">Rajastan</option>
			</select></Td>
			<Td><select name="City">
					<option value="" selected>-:Select a City:-</option>

			</select></Td>
			<Td><select name="Place">
					<option value="" selected>-:Select a Place:-</option>

			</select></Td>
		</Tr>
	</Table>
</body>
</html>