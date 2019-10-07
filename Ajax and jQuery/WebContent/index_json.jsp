<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajax</title>
<script type="text/javascript" src="jquery.mini.js"></script>

<script>
	$(document).ready(function() {
		$('#fn').change(function(event) {
			var fn = $('#fn').val();
			$.get('log', {
				fn : fn
			}, function(responseText) {
				$('#display').html(responseText);
			});

		});
	});
</script>
<script type="text/javascript">
$(document).ready(function(){
	$('#s').click(function(event){
		alert('Enter Username');
	});
});

</script>
<script type="text/javascript" language="javascript">
	$(document).ready(function() {
		$("p").css("background-color", "yellow");
	});
</script>

</head>


<body>
	<div align="center">
		<form action="logs" method="post">
			Roll no <input type="text" name="r" id="r"> <br> First
			Name <input type="text" name="fn" id="fn"> <br> User
			Name <input type="text" name="un" id="un"> <br> Password
			<input type="password" name="pw" id="pw"> <br>
			<div id="display" style="color: red;">
				<input type="button" value="Submit" id="s">
			</div>
		</form>
	</div>
</body>
</html>