
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	
	 <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.min.js" /></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.3.min.js" /></script>

<!-- Below code need to addd to jsp for validations -->

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath()%>/js/jquery-1.4.min.js" type="text/javascript"></script>
<script	src="<%=request.getContextPath()%>/js/jquery.validationEngine-en.js"	type="text/javascript"></script>
<script	src="<%=request.getContextPath()%>/js/jquery.validationEngine.js"	type="text/javascript"></script>

 
<style>
*{ margin:0px;
padding:0px;
}
body
{
font-family:Arial, Helvetica, sans-serif;
font-size:13px;

}
input
{
width:220px;
height:25px;
font-size:13px;
margin-bottom:10px;
border:solid 1px #333333;

}
label.error 
{

font-size:11px;
background-color:#cc0000;
color:#FFFFFF;
padding:3px;
margin-left:5px;
-moz-border-radius: 4px;
-webkit-border-radius: 4px; 
}


</style>
		<title><tiles:insertAttribute name="title" ignore="true" />
		</title>
	</head>


	<body>
					<tiles:insertAttribute name="body" />
					
	</body>
	</html>
