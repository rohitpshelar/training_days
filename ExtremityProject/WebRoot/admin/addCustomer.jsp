<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>AJAX in Struts 2 using JSON and jQuery</title>
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>



<script>
$(document).ready(function() {
	
	
$('#country').change(function(event) {
	alert("HI");
		var country = $("select#country").val();
		$.get('ajaxAction', {
			countryName : country
		}, function(jsonResponse) {
			$('#ajaxResponse').text(jsonResponse.dummyMsg);
			var select = $('#states');
			select.find('option').remove();
			$.each(jsonResponse.stateMap, function(key, value) {
				$('<option>').val(key).text(value).appendTo(select);
			});
		});
	});	
	
	
	
});

function abc()
{
alert("****");

	alert("a");
		var state = $("select#states").val();
		$.getJSON('stateAction', {
			stateName : state
		}, function(jsonResponse) {
		alert(jsonResponse);
			$('#ajaxResponse').text(jsonResponse.dummyMsg);
			var select = $('#city');
			select.find('option').remove();
			$.each(jsonResponse.cityMap, function(key, value) {
				$('<option>').val(key).text(value).appendTo(select);
			});
		});


}
</script>
</head>
<body>

<h3>AJAX calls to Struts 2 using JSON and jQuery</h3>
	<%--<s:select id="country" name="country"
		list="{'Select Country','India','US'}" label="Select Country"/>
	<br />
	<br />
	<s:select id="states" name="states" list="{'Select State'}"
		label="Select State" onchange="abc()"/>
	--%>
	
	<s:select list="statelist" id="states" listKey="sid" listValue="sname" headerKey="--select---" onchange="abc()"></s:select>
	
	<br />
	<br />
	<s:select id="city" name="city" list="{'Select City'}"
		label="Select City" />
	<br />
	<br />
	<div id="ajaxResponse"></div>
</body>
</html>